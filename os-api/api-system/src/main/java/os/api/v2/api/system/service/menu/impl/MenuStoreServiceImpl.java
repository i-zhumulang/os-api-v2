// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 00:07
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.menu.IMenuStoreService;
import os.api.v2.api.system.vo.menu.StoreVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.menu.impl.MenuStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 00:07
 */
@Service
public class MenuStoreServiceImpl implements IMenuStoreService {
    @Override
    public Result<String> store(StoreVo storeVo) {
        return null;
    }
}
