// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 10:13
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModuleDestroyService;
import os.api.v2.api.user.vo.rolemodule.DestroyVo;
import os.api.v2.api.user.vo.rolemodule.RoleModuleVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleDestroyServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 10:13
 */
@Service
public class RoleModuleDestroyServiceImpl implements IRoleModuleDestroyService {
    @DubboReference(version = "2.0.0")
    protected IRoleModuleService iRoleModuleService;

    @Override
    public Result<String> destroy(DestroyVo destroyVo) {
        RoleModuleModelVo roleModuleModelVo = new RoleModuleModelVo();
        roleModuleModelVo.setId(destroyVo.getId());
        return iRoleModuleService.destroy(roleModuleModelVo);
    }
}
