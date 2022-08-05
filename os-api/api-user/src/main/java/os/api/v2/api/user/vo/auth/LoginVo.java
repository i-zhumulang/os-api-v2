// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:45
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.auth;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;

/**
 * os.api.v2.api.user.vo.auth.LoginDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:45
 */
@Data
public class LoginVo implements Serializable {
    @NotBlank(message = "手机号码不能为空")
    @Length(min = 11, max = 11, message = "手机号码长度错误")
    private String mobile;

    @NotBlank(message = "密码不能为空")
    private String password;

}