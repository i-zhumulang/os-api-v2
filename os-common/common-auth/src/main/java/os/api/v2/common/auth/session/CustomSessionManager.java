// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-14 10:05
// +----------------------------------------------------------------------
package os.api.v2.common.auth.session;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**
 * os.api.v2.common.auth.session.CustomSessionManager
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-14 10:05
 */
public class CustomSessionManager extends DefaultWebSessionManager {
    /**
     * @param request  ServletRequest
     * @param response ServletResponse
     * @return java.io.Serializable
     * @author 吴荣超
     * @date 0:51 2022/5/8
     */
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        String id = WebUtils.toHttp(request).getHeader("Authorization");
        if (StringUtils.isEmpty(id)) {
            return super.getSessionId(request, response);
        } else {
            String token = id.replaceAll("Bearer ", "");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE, "header");
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, token);
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return token;
        }
    }
}