// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 16:42
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.vo.menu.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;

/**
 * os.api.v2.api.system.service.menu.IMenuUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 16:42
 */
public interface IMenuUpdateService {
    Result<MenuModelDto> update(UpdateVo updateVo);
}
