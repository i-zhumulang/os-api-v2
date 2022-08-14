// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 15:52
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.module;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

/**
 * os.api.v2.model.service.system.service.module.IUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 15:52
 */
public interface IUpdateService {
    Result<ModuleModelDto> update(ModuleModelVo moduleModelVo);
}
