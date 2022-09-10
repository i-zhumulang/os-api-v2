// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 00:10
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.vo.rolemodule.StoreVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 00:10
 */
public interface IRoleModuleStoreService {
    Result<String> store(StoreVo storeVo);
}
