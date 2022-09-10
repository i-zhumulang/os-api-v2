// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 00:17
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.rolemodule;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.vo.rolemodule.StoreModelVo;

/**
 * os.api.v2.model.service.user.service.rolemodule.IRoleModuleStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 00:17
 */
public interface IRoleModuleStoreService {
    Result<String> store(StoreModelVo storeModelVo);
}
