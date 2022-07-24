// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 17:04
// +----------------------------------------------------------------------
package os.api.v2.common.auth.filter;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import os.api.v2.common.auth.jwt.JwtToken;
import os.api.v2.common.base.common.Result;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * os.api.v2.common.auth.filter
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 17:04
 */
@Slf4j
public class JwtFilter extends BasicHttpAuthenticationFilter implements Filter {
    /**
     * 执行登录
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Authorization");
        if (token == null) {
            return false;
        }
        token = token.replaceAll("Bearer ", "");
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        try {
            getSubject(request, response).login(jwtToken);
            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (AuthenticationException e) {
            return false;
        }
    }

    /**
     * 执行登录认证
     *
     * @param request
     * @param response
     * @param mappedValue
     * @return
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        try {
            return executeLogin(request, response);
        } catch (Exception e) {
            log.error("JwtFilter过滤验证失败!");
            return false;
        }
    }

    /**
     * 认证失败时，自定义返回json数据
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Result<String> result = new Result<>(Result.FAILURE, "认证失败");
        Object parse = JSONObject.toJSON(result);
        response.setCharacterEncoding("utf-8");
        response.getWriter().print(parse);
        return super.onAccessDenied(request, response);
    }

    /**
     * 对跨域提供支持
     *
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        return super.preHandle(request, response);
    }
}
