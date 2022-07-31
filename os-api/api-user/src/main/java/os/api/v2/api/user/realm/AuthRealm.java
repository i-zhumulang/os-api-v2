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

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;
import os.api.v2.common.auth.realm.ShiroRealm;
import os.api.v2.common.base.utils.jwt.JwtUtils;

import java.util.HashSet;
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
}
