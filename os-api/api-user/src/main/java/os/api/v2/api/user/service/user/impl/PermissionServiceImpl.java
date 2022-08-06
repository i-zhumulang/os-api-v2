// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 23:35
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.user.IPermissionService;
import os.api.v2.api.user.vo.user.PermissionVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.common.base.utils.jwt.JwtUtils;
import os.api.v2.model.service.user.dto.userrole.UserRoleModelDto;
import os.api.v2.model.service.user.service.modulemenu.IModuleMenuService;
import os.api.v2.model.service.user.service.userrole.IUserRoleService;
import os.api.v2.model.service.user.vo.modulemenu.ModuleMenuModelVo;
import os.api.v2.model.service.user.vo.userrole.UserRoleModelVo;
import os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto;

import java.util.List;
import java.util.Objects;

/**
 * os.api.v2.api.user.service.user.impl.PermissionServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 23:35
 */
@Service
public class PermissionServiceImpl implements IPermissionService {
    @DubboReference(version = "2.0.0")
    protected IUserRoleService iUserRoleService;

    @DubboReference(version = "2.0.0")
    protected IModuleMenuService iModuleMenuService;

    @DubboReference(version = "2.0.0")
    protected os.api.v2.service.service.system.service.modulemenu.IPermissionService iPermissionService;

    @Override
    public Result<List<PermissionServiceDto>> permission(PermissionVo permissionVo) throws UserException {
        long userId = getUserId();
        UserRoleModelDto userRoleModelDto = getRoleId(userId);
        List<Integer> moduleMenuIdList = getModuleMenuIdList(userRoleModelDto.getRoleId(), permissionVo.getModuleId());
        return getModuleMenu(moduleMenuIdList);
    }

    private Result<List<PermissionServiceDto>> getModuleMenu(List<Integer> idList) {
        return iPermissionService.permission(idList);
    }

    /**
     * getModuleMenuIdList
     * 
     * @param roleId 角色ID
     * @param moduleId 当前模块ID
     * @return List<Integer>
     * @author 吴荣超
     * @date 0:52 2022/8/6
     */
    private List<Integer> getModuleMenuIdList(Integer roleId, Integer moduleId) throws UserException {
        ModuleMenuModelVo moduleMenuModelVo = new ModuleMenuModelVo();
        moduleMenuModelVo.setRoleId(roleId);
        moduleMenuModelVo.setModuleId(moduleId);
        Result<List<Integer>> result = iModuleMenuService.permission(moduleMenuModelVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException("没有模块");
        }
        return result.getData();
    }

    /**
     * getRoleId
     *
     * @param userId long
     * @return UserRoleModelDto
     * @author 吴荣超
     * @date 0:42 2022/8/6
     */
    private UserRoleModelDto getRoleId(long userId) throws UserException {
        UserRoleModelVo userRoleModelVo = new UserRoleModelVo();
        userRoleModelVo.setUserId(userId);
        Result<UserRoleModelDto> result = iUserRoleService.getRoleId(userRoleModelVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException("没有角色");
        }
        return result.getData();
    }

    /**
     * getUserId
     *
     * @return long
     * @author 吴荣超
     * @date 23:40 2022/8/5
     */
    public long getUserId() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principal = subject.getPrincipals();
        return JwtUtils.getUserId((String) principal.getPrimaryPrincipal());
    }
}
