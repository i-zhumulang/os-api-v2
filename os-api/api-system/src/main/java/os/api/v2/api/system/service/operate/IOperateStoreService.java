// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 22:37
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate;

import os.api.v2.api.system.vo.operate.StoreVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.operate.IOperateStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 22:37
 */
public interface IOperateStoreService {
    Result<String> store(StoreVo storeVo);
}
