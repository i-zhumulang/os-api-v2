// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-01 22:43
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.system.service.operate.IOperateOptionsService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-01 22:43
 */
public interface IOperateOptionsService {
    Result<Map<String, Object>> options();
}
