// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-11-08 23:32
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.vo.rolemodule.PermissionStoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModulePermissionStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-11-08 23:32
 */
public interface IRoleModulePermissionStoreService {
    Result<String> permissionStore(PermissionStoreVo permissionStoreVo) throws UserException;
}
