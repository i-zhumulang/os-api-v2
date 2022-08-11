// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-10 22:29
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module;

import org.springframework.stereotype.Service;
import os.api.v2.api.system.vo.module.StoreVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.module.IStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-10 22:29
 */
public interface IStoreService {
    Result<String> store(StoreVo storeVo);
}
