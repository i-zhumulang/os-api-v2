// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 23:46
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.userrole;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.userrole.UserRoleModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 23:46
 */
@Data
public class UserRoleModelVo implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户ID
     */
    private Long userId;
}
