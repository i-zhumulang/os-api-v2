// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:43
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.user;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.user.RegisterVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:43
 */
@Data
public class RegisterVo {
    private String mobile;

    private String password;

    private String passwordConfirm;
}
