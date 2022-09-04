// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 22:43
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.operate.IOperateStoreService;
import os.api.v2.api.system.vo.operate.StoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.utils.IdWorkerUtils;
import os.api.v2.model.service.system.vo.menuoperate.StoreModelVo;

/**
 * os.api.v2.api.system.service.operate.impl.OperateStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 22:43
 */
@Service
public class OperateStoreServiceImpl implements IOperateStoreService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menuoperate.IOperateStoreService iOperateStoreService;

    @Override
    public Result<String> store(StoreVo storeVo) {
        StoreModelVo storeModelVo = new StoreModelVo();
        BeanUtils.copyProperties(storeVo, storeModelVo);
        storeModelVo.setId(new IdWorkerUtils().nextId());
        return iOperateStoreService.store(storeModelVo);
    }
}
