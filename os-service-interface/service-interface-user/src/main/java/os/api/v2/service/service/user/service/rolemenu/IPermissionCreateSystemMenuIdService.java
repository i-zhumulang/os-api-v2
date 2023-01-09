// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-09 22:17
// +----------------------------------------------------------------------
package os.api.v2.service.service.user.service.rolemenu;

import os.api.v2.common.base.common.Result;

import java.util.List;

/**
 * os.api.v2.service.service.user.service.rolemenu.IPermissionCreateMenuIdService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-09 22:17
 */
public interface IPermissionCreateSystemMenuIdService {
    Result<List<Long>> permissionCreateMenuId(Long roleModuleId);
}
