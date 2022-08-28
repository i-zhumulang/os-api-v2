// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 12:55
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.dto.menu.CreateDto;
import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.menu.IMenuEditService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 12:55
 */
public interface IMenuEditService {
    Result<CreateDto> edit(MenuVo menuVo);
}
