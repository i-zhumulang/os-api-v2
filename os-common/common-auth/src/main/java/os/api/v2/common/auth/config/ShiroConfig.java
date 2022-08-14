// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 19:48
// +----------------------------------------------------------------------
package os.api.v2.common.auth.config;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import os.api.v2.common.auth.realm.ShiroRealm;
import os.api.v2.common.auth.session.CustomSessionManager;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * os.api.v2.common.auth.config
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 19:48
 */
@Configuration
public class ShiroConfig {

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Bean
    public ShiroRealm shiroRealm() {
        return new ShiroRealm();
    }

    @Bean
    public SecurityManager getSecurityManager(ShiroRealm shiroRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(shiroRealm);

        securityManager.setSessionManager(sessionManager());
        securityManager.setCacheManager(cacheManager());

        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        // 创建过滤器工厂
        ShiroFilterFactoryBean filterFactory = new ShiroFilterFactoryBean();
        // 设置安全管理器
        filterFactory.setSecurityManager(securityManager);
        // 跳转url地址(跳转登录页面,未授权跳转的页面)
        filterFactory.setLoginUrl("http://127.0.0.1:8080/api-user/auth/authenticated?code=3");
        // 未授权的URL
        filterFactory.setUnauthorizedUrl("http://127.0.0.1:8080/api-user/auth/authenticated?code=4");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/auth/login", "anon");
        filterMap.put("/user/register", "anon");
        filterMap.put("/auth/authenticated", "anon");
        filterMap.put("/**", "authc");
        filterFactory.setFilterChainDefinitionMap(filterMap);

        return filterFactory;
    }

    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        return redisManager;
    }

    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        redisSessionDAO.setExpire(3600);
        redisSessionDAO.setKeyPrefix("os:api:");
        return redisSessionDAO;
    }

    public DefaultWebSessionManager sessionManager() {
        CustomSessionManager sessionManager = new CustomSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        // 禁用cookie
        sessionManager.setSessionIdCookieEnabled(false);
        // 禁用url重写
        sessionManager.setSessionIdUrlRewritingEnabled(false);
        return sessionManager;
    }

    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }
}
