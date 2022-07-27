// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:45
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.auth;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.api.user.dto.auth.LoginDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:45
 */
@Data
public class LoginDto implements Serializable {
    private String mobile;

    private String password;
}