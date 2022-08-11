// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-10 22:30
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.module.IStoreService;
import os.api.v2.api.system.vo.module.StoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.vo.module.StoreModelVo;

/**
 * os.api.v2.api.system.service.module.impl.StoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-10 22:30
 */
@Service
public class StoreServiceImpl implements IStoreService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.module.IStoreService iStoreService;

    @Override
    public Result<String> store(StoreVo storeVo) {
        StoreModelVo storeModelVo = new StoreModelVo();
        BeanUtils.copyProperties(storeVo, storeModelVo);
        return iStoreService.store(storeModelVo);
    }
}
