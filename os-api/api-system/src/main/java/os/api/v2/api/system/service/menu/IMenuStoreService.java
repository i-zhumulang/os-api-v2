// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-27 21:44
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.vo.menu.StoreVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.menu.IMenuStoreService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-27 21:44
 */
public interface IMenuStoreService {
    Result<String> store(StoreVo storeVo);
}
