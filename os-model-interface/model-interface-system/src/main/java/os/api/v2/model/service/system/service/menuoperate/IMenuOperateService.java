// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 22:45
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.vo.menuoperate.MenuOperateModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.menuoperate.IMenuOperateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 22:45
 */
public interface IMenuOperateService {
    Result<String> destroy(MenuOperateModelDto menuOperateModelDto);
    Result<List<MenuOperateModelDto>> getMenuOperateList(MenuOperateModelVo menuOperateModelVo);
}
