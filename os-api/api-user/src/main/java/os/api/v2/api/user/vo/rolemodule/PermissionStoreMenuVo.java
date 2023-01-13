// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-13 20:50
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.rolemodule.PermissionStoreMenuVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-13 20:50
 */
@Data
public class PermissionStoreMenuVo {
    private Long systemMenuId;
    private Long systemModuleId;
    private Long parentId;
}
