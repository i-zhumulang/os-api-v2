// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 16:55
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.system.service.module.IModuleOptionsService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 16:55
 */
public interface IModuleOptionsService {
    Result<Map<String, Object>> options();
}
