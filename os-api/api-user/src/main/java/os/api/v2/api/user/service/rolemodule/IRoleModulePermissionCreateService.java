// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-11-06 10:34
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.dto.rolemodule.PermissionCreateDto;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModulePermissionCreateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-11-06 10:34
 */
public interface IRoleModulePermissionCreateService {
    Result<Map<String, Object>> permissionCreate(Long id) throws UserException;
}
