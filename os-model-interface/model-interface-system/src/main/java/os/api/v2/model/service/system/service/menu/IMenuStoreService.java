// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 10:38
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.vo.menu.StoreModelVo;

/**
 * os.api.v2.model.service.system.service.menu.IMenuStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 10:38
 */
public interface IMenuStoreService {
    Result<String> store(StoreModelVo storeModelVo);
}
