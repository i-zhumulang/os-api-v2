// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 00:11
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModuleStoreService;
import os.api.v2.api.user.vo.rolemodule.StoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.utils.IdWorkerUtils;
import os.api.v2.model.service.user.vo.rolemodule.StoreModelVo;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 00:11
 */
@Service
public class RoleModuleStoreServiceImpl implements IRoleModuleStoreService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.rolemodule.IRoleModuleStoreService iRoleModuleStoreService;

    @Override
    public Result<String> store(StoreVo storeVo) {
        StoreModelVo storeModelVo = new StoreModelVo();
        BeanUtils.copyProperties(storeVo, storeModelVo);
        storeModelVo.setId(new IdWorkerUtils().nextId());
        return iRoleModuleStoreService.store(storeModelVo);
    }
}
