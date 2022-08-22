// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 00:14
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.menu;

import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto;

import java.util.List;

/**
 * os.api.v2.service.service.system.service.menu.IPermissionService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 00:14
 */
public interface IPermissionService {
    Result<List<PermissionServiceDto>> permission(List<Long> idList);
}
