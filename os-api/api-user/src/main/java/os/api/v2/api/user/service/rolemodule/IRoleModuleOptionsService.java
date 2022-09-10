// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 21:51
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleOptionsService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 21:51
 */
public interface IRoleModuleOptionsService {
    Result<Map<String, Object>> options();
}
