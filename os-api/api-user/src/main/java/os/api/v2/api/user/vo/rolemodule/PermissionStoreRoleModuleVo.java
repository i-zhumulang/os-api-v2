// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-13 23:06
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.rolemodule.PermissionStoreRoleModuleVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-13 23:06
 */
@Data
public class PermissionStoreRoleModuleVo {
    private Long id;
    private Integer roleId;
    private Long systemModuleId;
}
