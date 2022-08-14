// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:06
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.auth.impl;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.vo.auth.LoginVo;
import os.api.v2.api.user.service.auth.ILoginService;
import os.api.v2.common.base.common.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * os.api.v2.api.user.service.auth.impl.LoginServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:06
 */
@Service
public class LoginServiceImpl implements ILoginService {

    /**
     * login
     *
     * @param loginVo 登录表单
     * @return Result<Map < String, Object>>
     * @author 吴荣超
     * @date 20:52 2022/7/26
     */
    @Override
    public Result<Map<String, Object>> login(LoginVo loginVo) {
        try {
            // TODO 对前端传输的密码进行解密
            // 构造登录令牌
            UsernamePasswordToken token = new UsernamePasswordToken(loginVo.getMobile(), loginVo.getPassword());
            // 获取subject
            Subject subject = SecurityUtils.getSubject();
            // 调用login方法，完成realm认证
            subject.login(token);
            // 获取sessionId
            String sessionId = (String) subject.getSession().getId();
            // 构造返回结果
            Map<String, Object> map = new HashMap<>();
            map.put("token", sessionId);
            return new Result<>(Result.SUCCESS, "登录成功", map);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result<>(Result.FAILURE, "用户名或密码错误");
        }
    }
}