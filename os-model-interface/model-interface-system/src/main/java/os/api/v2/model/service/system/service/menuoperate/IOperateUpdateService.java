// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 00:17
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.vo.menuoperate.UpdateModelVo;

/**
 * os.api.v2.model.service.system.service.menuoperate.IOperateUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 00:17
 */
public interface IOperateUpdateService {
    Result<MenuOperateModelDto> update(UpdateModelVo updateModelVo);
}
