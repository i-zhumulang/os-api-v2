// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 22:09
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.vo.menuoperate.IndexModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.menuoperate.IOperateIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 22:09
 */
public interface IOperateIndexService {
    Result<List<MenuOperateModelDto>> index(IndexModelVo indexModelVo);
}
