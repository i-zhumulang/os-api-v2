// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-10 22:33
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.module;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.vo.module.StoreModelVo;

/**
 * os.api.v2.model.service.system.service.module.IStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-10 22:33
 */
public interface IStoreService {
    Result<String> store(StoreModelVo storeModelVo);
}
