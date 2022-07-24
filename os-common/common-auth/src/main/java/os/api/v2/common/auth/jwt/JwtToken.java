// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 17:03
// +----------------------------------------------------------------------
package os.api.v2.common.auth.jwt;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * os.api.v2.common.auth.jwt
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 17:03
 */
public class JwtToken implements AuthenticationToken {
    private final String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
