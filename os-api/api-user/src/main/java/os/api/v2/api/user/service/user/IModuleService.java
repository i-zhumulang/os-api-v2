// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-02 23:33
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user;

import os.api.v2.common.base.common.Result;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.service.user.IModuleService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-02 23:33
 */
public interface IModuleService {
    Result<List<Map<String, Object>>> module();
}
