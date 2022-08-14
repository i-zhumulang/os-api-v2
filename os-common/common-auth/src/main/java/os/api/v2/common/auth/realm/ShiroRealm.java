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

import lombok.extern.slf4j.Slf4j;
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
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * os.api.v2.common.auth.realm
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 17:07
 */
@Slf4j
public class ShiroRealm extends AuthorizingRealm {
    public void setName(String name) {
        super.setName("ShiroRealm");
    }

    /**
     * 认证
     *
     * @param authenticationToken AuthenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @author 吴荣超
     * @date 0:50 2022/5/8
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }

    /**
     * 授权
     *
     * @param principalCollection PrincipalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     * @author 吴荣超
     * @date 0:50 2022/5/8
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取安全数据
        Profile result = (Profile) principalCollection.getPrimaryPrincipal();
        //获取权限信息
        Set<String> apisPerms = (Set<String>) result.getRoles().get("apis");
        //构造权限信息,返回值
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(apisPerms);
        return info;
    }
}
