// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 19:17
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.menu.IMenuDestroyService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 19:17
 */
public interface IMenuDestroyService {
    Result<String> destroy(MenuVo menuVo);
}
