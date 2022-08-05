// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 00:54
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.modulemenu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.modulemenu.ModuleMenuModelDto;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.modulemenu.IModuleMenuService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 00:54
 */
public interface IModuleMenuService {
    Result<List<ModuleMenuModelDto>> permission(List<Integer> idList, String[] fieldArray);
}
