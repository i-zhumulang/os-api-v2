// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-29 22:21
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.system.service.menu.IMenuOptionsService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-29 22:21
 */
public interface IMenuOptionsService {
    Result<Map<String, Object>> options();
}
