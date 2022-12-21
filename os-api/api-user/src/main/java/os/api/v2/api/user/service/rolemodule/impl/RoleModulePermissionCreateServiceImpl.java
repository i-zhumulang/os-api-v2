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

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModulePermissionCreateService;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;
import os.api.v2.service.service.system.dto.menu.MenuServiceDto;
import os.api.v2.service.service.system.dto.menuoperate.MenuOperateServiceDto;
import os.api.v2.service.service.system.service.menu.IMenuService;
import os.api.v2.service.service.system.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.system.vo.menu.MenuServiceVo;
import os.api.v2.service.service.system.vo.menuoperate.MenuOperateServiceVo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModulePermissionCreateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-11-08 23:22
 */
@Service
public class RoleModulePermissionCreateServiceImpl implements IRoleModulePermissionCreateService {
    @DubboReference(version = "2.0.0")
    protected IRoleModuleService iRoleModuleService;
    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @Override
    public Result<List<Object>> permissionCreate(Long id) throws UserException {
        RoleModuleModelDto roleModuleModelDto = getRoleModuleModelDto(id);
        List<MenuServiceDto> menuServiceDtoList = getMenuServiceDto(roleModuleModelDto.getSystemModuleId());
        Map<Long, List<MenuOperateServiceDto>> menuOperateServiceDto = getMenuOperateServiceDto(roleModuleModelDto.getSystemModuleId());
        return null;
    }

    private RoleModuleModelDto getRoleModuleModelDto(Long id) throws UserException {
        RoleModuleModelVo modelVo = new RoleModuleModelVo();
        modelVo.setId(id);
        modelVo.setFieldArray(new String[]{"id", "system_module_id"});
        Result<RoleModuleModelDto> result = iRoleModuleService.getSingle(modelVo);
        if (Objects.equals(Result.FAILURE, result.getFlag())) {
            throw new UserException("数据不存在");
        }
        return result.getData();
    }

    private List<MenuServiceDto> getMenuServiceDto(Long systemModuleId) {
        MenuServiceVo serviceVo = new MenuServiceVo();
        serviceVo.setModuleId(systemModuleId);
        return iMenuService.getMenuList(serviceVo).getData();
    }

    private Map<Long, List<MenuOperateServiceDto>> getMenuOperateServiceDto(Long systemModuleId) {
        MenuOperateServiceVo serviceVo = new MenuOperateServiceVo();
        serviceVo.setModuleId(systemModuleId);
        Result<List<MenuOperateServiceDto>> result = iMenuOperateService.getMenuOperateList(serviceVo);

        return result.getData()
                .stream()
                .collect(
                        Collectors.groupingBy(
                                MenuOperateServiceDto::getMenuId
                        )
                );
    }
}
