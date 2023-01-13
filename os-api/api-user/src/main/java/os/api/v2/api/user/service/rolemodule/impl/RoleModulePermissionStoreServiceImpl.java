// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-11-08 23:32
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModulePermissionStoreService;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreRoleModuleVo;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;

import java.util.Objects;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModulePermissionStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-11-08 23:32
 */
@Service
public class RoleModulePermissionStoreServiceImpl implements IRoleModulePermissionStoreService {
    @DubboReference(version = "2.0.0")
    protected IRoleModuleService iRoleModuleService;

    @Override
    public Result<String> permissionStore(PermissionStoreVo permissionStoreVo) throws UserException {
        RoleModuleModelDto roleModuleModelDto = getRoleModuleModelDto(permissionStoreVo.getRoleModule());
        return null;
    }

    private RoleModuleModelDto getRoleModuleModelDto(PermissionStoreRoleModuleVo roleModuleVo) throws UserException {
        RoleModuleModelVo modelVo = new RoleModuleModelVo();
        modelVo.setId(roleModuleVo.getId());
        modelVo.setFieldArray(new String[]{"id", "role_id", "system_module_id"});
        Result<RoleModuleModelDto> result = iRoleModuleService.getSingle(modelVo);
        if (Objects.equals(Result.FAILURE, result.getFlag())) {
            throw new UserException("数据不存在");
        }
        RoleModuleModelDto roleModuleModelDto = result.getData();
        if (!Objects.equals(roleModuleModelDto.getRoleId(), roleModuleVo.getRoleId())) {
            throw new UserException("数据已经更变,刷新重试:1001");
        }
        if (!Objects.equals(roleModuleModelDto.getSystemModuleId(), roleModuleVo.getSystemModuleId())) {
            throw new UserException("数据已经更变,刷新重试:1002");
        }
        return result.getData();
    }
}
