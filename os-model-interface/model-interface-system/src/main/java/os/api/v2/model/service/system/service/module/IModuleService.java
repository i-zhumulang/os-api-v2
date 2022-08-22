// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-03 00:14
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.module;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.module.IModuleService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-03 00:14
 */
public interface IModuleService {
    Result<List<ModuleModelDto>> getModuleByIdList(List<Long> id, String[] fieldArray);
    Result<ModuleModelDto> getModuleDto(ModuleModelVo moduleModelVo, String[] fieldArray);
}
