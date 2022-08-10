// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:27
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.user.vo.menuoperate.MenuOperateModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.menuoperate.IMenuOperateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:27
 */
public interface IMenuOperateService {
    Result<List<MenuOperateModelDto>> systemMenuOperateList(MenuOperateModelVo menuOperateModelVo, String[] fieldArray);
}
