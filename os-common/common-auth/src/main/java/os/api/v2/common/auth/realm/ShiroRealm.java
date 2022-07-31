// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 17:07
// +----------------------------------------------------------------------
package os.api.v2.common.auth.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import os.api.v2.common.auth.jwt.JwtToken;
import os.api.v2.common.base.utils.jwt.JwtUtils;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * os.api.v2.common.auth.realm
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 17:07
 */
@Component
public class ShiroRealm extends AuthorizingRealm {
    @Autowired
    protected StringRedisTemplate redisTemplate;

    /**
     * redis过期时间设置
     */
    @Value("${custom.jwt.expire_time}")
    protected long expireTime;

    /**
     * 设置对应的token类型
     * 必须重写此方法，不然Shiro会报错
     *
     * @param token 令牌
     * @return boolean
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        String token = (String) SecurityUtils.getSubject().getPrincipal();
        Long userId = JwtUtils.getUserId(token);
        //模拟数据库校验,写死用户名xsy，其他用户无法登陆成功
        if (userId == null) {
            return null;
        }
        //创建授权信息
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //创建set集合，存储权限
        HashSet<String> rootSet = new HashSet<>();
        //添加权限
        rootSet.add("user:show");
        rootSet.add("user:admin");
        //设置权限
        info.setStringPermissions(rootSet);
        //返回权限实例
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("开始身份认证.....................");
        //获取token
        String token = (String) authenticationToken.getCredentials();
        //创建字符串，存储用户信息
        Long userId = null;
        try {
            //获取用户名
            userId = JwtUtils.getUserId(token);
        } catch (AuthenticationException e) {
            throw new AuthenticationException("heard的token拼写错误或者值为空");
        }
        if (userId == null) {
            throw new AuthenticationException("token无效");
        }
        // 校验token是否超时失效 & 或者账号密码是否错误
        if (!jwtTokenRefresh(token, userId, JwtUtils.SECRET)) {
            throw new AuthenticationException("Token失效，请重新登录!");
        }
        //返回身份认证信息
        return new SimpleAuthenticationInfo(token, token, "my_realm");
    }

    /**
     * jwt刷新令牌
     *
     * @param token    令牌
     * @param userId   用户名ID
     * @param passWord 通过单词
     * @return boolean
     */
    public boolean jwtTokenRefresh(String token, Long userId, String passWord) {
        String redisToken = redisTemplate.opsForValue().get(token);
        if (redisToken != null) {
            if (!JwtUtils.verify(redisToken, userId)) {
                String newToken = JwtUtils.sign(userId);
                //设置redis缓存
                redisTemplate.opsForValue().set(token, newToken, expireTime * 2 / 1000, TimeUnit.SECONDS);
            }
            return true;
        }
        return false;
    }
}
