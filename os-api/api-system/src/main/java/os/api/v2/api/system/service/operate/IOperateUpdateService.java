// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 00:12
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate;

import os.api.v2.api.system.vo.operate.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;

/**
 * os.api.v2.api.system.service.operate.IOperateUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 00:12
 */
public interface IOperateUpdateService {
    Result<MenuOperateModelDto> update(UpdateVo updateVo);
}
