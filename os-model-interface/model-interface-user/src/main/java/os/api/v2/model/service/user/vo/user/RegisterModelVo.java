// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:48
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.user.RegisterModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:48
 */
@Data
public class RegisterModelVo implements Serializable {

    private Long id;

    private String iv;

    private String salt;

    private String mobile;

    private Long createdAt;

    private String authentication;

}
