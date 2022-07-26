// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 23:30
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.menu.IMenuService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 23:30
 */
public interface IMenuService {
    Result<String> destroy(MenuModelVo menuModelVo);
    Result<List<MenuModelDto>> getMenuList(MenuModelVo menuModelVo);
}
