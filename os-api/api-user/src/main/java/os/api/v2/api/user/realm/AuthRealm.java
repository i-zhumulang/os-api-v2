// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 21:00
// +----------------------------------------------------------------------
package os.api.v2.api.user.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.springframework.stereotype.Component;
import os.api.v2.common.auth.realm.ShiroRealm;
import os.api.v2.common.base.utils.jwt.JwtUtils;

import java.util.concurrent.TimeUnit;

/**
 * os.api.v2.api.user.realm
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 21:00
 */
@Component
public class AuthRealm extends ShiroRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始身份认证.....................");
        //获取token
        String token = (String) authenticationToken.getCredentials();
        //创建字符串，存储用户信息
        String username = null;
        try {
            //获取用户名
            username = JwtUtils.getUsername(token);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (username == null) {
            throw new AuthenticationException("token无效");
        }
        // 校验token是否超时失效 & 或者账号密码是否错误
        if (!jwtTokenRefresh(token, username, JwtUtils.SECRET)) {
            throw new AuthenticationException("Token失效，请重新登录!");
        }
        //返回身份认证信息
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

    /**
     * jwt刷新令牌
     *
     * @param token    令牌
     * @param userName 用户名
     * @param passWord 通过单词
     * @return boolean
     */
    public boolean jwtTokenRefresh(String token, String userName, String passWord) {
        String redisToken = redisTemplate.opsForValue().get(token);
        if (redisToken != null) {
            if (!JwtUtils.verify(redisToken, userName)) {
                String newToken = JwtUtils.sign(userName);
                //设置redis缓存
                redisTemplate.opsForValue().set(token, newToken, expireTime * 2 / 1000, TimeUnit.SECONDS);
            }
            return true;
        }
        return false;
    }
}
