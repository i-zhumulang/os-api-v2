// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-09 22:19
// +----------------------------------------------------------------------
package os.api.v2.service.impl.user.service.rolemenu;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.service.rolemenu.IRoleMenuService;
import os.api.v2.model.service.user.vo.rolemenu.RoleMenuModelVo;
import os.api.v2.service.service.user.service.rolemenu.IPermissionCreateSystemMenuIdService;

import java.util.List;

/**
 * os.api.v2.service.impl.user.service.rolemenu.PermissionCreateSystemMenuIdServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-09 22:19
 */
@DubboService(version = "2.0.0")
public class PermissionCreateSystemMenuIdServiceImpl implements IPermissionCreateSystemMenuIdService {
    @DubboReference(version = "2.0.0")
    protected IRoleMenuService iRoleMenuService;

    @Override
    public Result<List<Long>> permissionCreateSystemMenuId(Long roleModuleId) {
        RoleMenuModelVo modelVo = new RoleMenuModelVo();
        modelVo.setRoleModuleId(roleModuleId);
        modelVo.setGrade(1);

        return iRoleMenuService.permission(modelVo);
    }
}
