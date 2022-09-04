// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 22:45
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.vo.menuoperate.StoreModelVo;

/**
 * os.api.v2.model.service.system.service.menuoperate.IOperateStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 22:45
 */
public interface IOperateStoreService {
    Result<String> store(StoreModelVo storeModelVo);
}
