// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-27 21:44
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.common.base.common.Result;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.service.menu.IMenuCreateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-27 21:44
 */
public interface IMenuCreateService {
    Result<Map<Long, Map<String, Object>>> create();
}
