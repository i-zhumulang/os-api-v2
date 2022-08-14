// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 08:08
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module;

import os.api.v2.api.system.dto.module.EditDto;
import os.api.v2.api.system.vo.module.EditVo;
import os.api.v2.api.system.vo.module.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;

/**
 * os.api.v2.api.system.service.module.IUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 08:08
 */
public interface IUpdateService {
    Result<EditDto> edit(EditVo editVo);
    Result<ModuleModelDto> update(UpdateVo updateVo);
}
