// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-26 22:24
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.module.IDestroyService;
import os.api.v2.api.system.vo.module.ModuleVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

/**
 * os.api.v2.api.system.service.module.impl.DestroyServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-26 22:24
 */
@Service
public class DestroyServiceImpl implements IDestroyService {
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @Override
    public Result<String> destroy(ModuleVo moduleVo) {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setId(moduleVo.getId());
        return iModuleService.destroy(moduleModelVo);
    }
}
