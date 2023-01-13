// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-13 20:52
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.rolemodule.PermissionStoreOperateVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-13 20:52
 */
@Data
public class PermissionStoreOperateVo {
    private Long systemOperateId;
    private Long systemModuleId;
    private Long systemMenuId;
}
