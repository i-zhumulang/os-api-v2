// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:06
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.modulemenu;

import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.service.service.system.service.modulemenu.IModuleMenuService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:06
 */
public interface IModuleMenuService {
    Result<List<PermissionServiceDto>> permission(List<Integer> idList);
}
