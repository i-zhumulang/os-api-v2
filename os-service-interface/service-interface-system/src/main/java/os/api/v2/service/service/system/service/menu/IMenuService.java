// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 23:47
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.menu;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.service.service.system.service.menu.IMenuService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 23:47
 */
public interface IMenuService {
    Result<Map<Long, String>> getMenuIdNameZhMap();
}
