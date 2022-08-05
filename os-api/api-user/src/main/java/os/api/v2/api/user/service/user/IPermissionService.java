// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 23:34
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user;

import os.api.v2.api.user.vo.user.PermissionVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.service.user.IPermissionService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 23:34
 */
public interface IPermissionService {
    Result<List<PermissionServiceDto>> permission(PermissionVo permissionVo) throws UserException;
}
