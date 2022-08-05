// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 20:06
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.module;

import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.dto.module.ModuleServiceDto;
import os.api.v2.service.service.system.vo.module.ModuleServiceVo;

import java.util.List;

/**
 * os.api.v2.service.service.system.service.module.IModuleService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 20:06
 */
public interface IModuleService {
    Result<List<ModuleServiceDto>> getModuleByIdList(ModuleServiceVo moduleServiceVo);
}