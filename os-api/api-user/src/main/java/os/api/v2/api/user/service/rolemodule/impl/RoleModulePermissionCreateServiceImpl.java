// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-11-08 23:22
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModulePermissionCreateService;
import os.api.v2.common.base.common.Result;

import java.util.List;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModulePermissionCreateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-11-08 23:22
 */
@Service
public class RoleModulePermissionCreateServiceImpl implements IRoleModulePermissionCreateService {
    @Override
    public Result<List<Object>> permissionCreate() {
        return null;
    }
}
