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
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.rolemodule.PermissionCreateDto;
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
import os.api.v2.service.service.user.service.rolemenu.IPermissionCreateSystemMenuIdService;
import os.api.v2.service.service.user.service.roleoperate.IPermissionCreateSystemOperateIdService;

import java.util.*;
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

    @DubboReference(version = "2.0.0")
    protected IPermissionCreateSystemMenuIdService iPermissionCreateSystemMenuIdService;

    @DubboReference(version = "2.0.0")
    protected IPermissionCreateSystemOperateIdService iPermissionCreateSystemOperateIdService;

    @Override
    public Result<Map<String, Object>> permissionCreate(Long id) throws UserException {
        RoleModuleModelDto roleModuleModelDto = getRoleModuleModelDto(id);
        Map<String, Object> map = new HashMap<>();
        map.put("menus", getPermissionCreateDtoList(roleModuleModelDto));
        map.put("default", getDefaultPermission(roleModuleModelDto));
        return new Result<>(Result.SUCCESS, map);
    }

    private List<PermissionCreateDto> getPermissionCreateDtoList(RoleModuleModelDto roleModuleModelDto) throws UserException {

        List<PermissionCreateDto> permissionCreateDtoList = getMenuServiceDto(roleModuleModelDto.getSystemModuleId());
        Map<Long, List<PermissionCreateDto>> permissionCreateDtoMap = getMenuOperateServiceDto(roleModuleModelDto.getSystemModuleId());

        List<PermissionCreateDto> list = new ArrayList<>();
        for (PermissionCreateDto permissionCreateDto : permissionCreateDtoList) {
            List<PermissionCreateDto> children = permissionCreateDtoMap.get(permissionCreateDto.getId());
            permissionCreateDto.setChildren(children);
            list.add(permissionCreateDto);
        }
        return list;
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

    private List<PermissionCreateDto> getMenuServiceDto(Long systemModuleId) {
        MenuServiceVo serviceVo = new MenuServiceVo();
        serviceVo.setModuleId(systemModuleId);
        Result<List<MenuServiceDto>> result = iMenuService.getMenuList(serviceVo);
        List<PermissionCreateDto> list = new ArrayList<>();
        for (MenuServiceDto menuServiceDto : result.getData()) {
            PermissionCreateDto permissionCreateDto = new PermissionCreateDto();
            permissionCreateDto.setId(menuServiceDto.getId());
            permissionCreateDto.setLabel(menuServiceDto.getNameZh());
            permissionCreateDto.setType("menu");
            permissionCreateDto.setModuleId(menuServiceDto.getModuleId());
            permissionCreateDto.setLeaderId(menuServiceDto.getParentId());
            permissionCreateDto.setChildren(new ArrayList<>());
            list.add(permissionCreateDto);
        }
        return list;
    }

    private Map<Long, List<PermissionCreateDto>> getMenuOperateServiceDto(Long systemModuleId) {
        MenuOperateServiceVo serviceVo = new MenuOperateServiceVo();
        serviceVo.setModuleId(systemModuleId);
        Result<List<MenuOperateServiceDto>> result = iMenuOperateService.getMenuOperateList(serviceVo);

        List<PermissionCreateDto> list = new ArrayList<>();
        for (MenuOperateServiceDto menuOperateServiceDto : result.getData()) {
            PermissionCreateDto permissionCreateDto = new PermissionCreateDto();
            permissionCreateDto.setId(menuOperateServiceDto.getId());
            permissionCreateDto.setLabel(menuOperateServiceDto.getNameZh());
            permissionCreateDto.setType("operate");
            permissionCreateDto.setModuleId(menuOperateServiceDto.getModuleId());
            permissionCreateDto.setLeaderId(menuOperateServiceDto.getMenuId());
            permissionCreateDto.setChildren(new ArrayList<>());
            list.add(permissionCreateDto);
        }
        return list.stream()
                .collect(
                        Collectors.groupingBy(
                                PermissionCreateDto::getLeaderId
                        )
                );
    }

    private List<Long> getDefaultPermission(RoleModuleModelDto roleModuleModelDto) {
        // 获取已有权限菜单ID
        Result<List<Long>> menuId = iPermissionCreateSystemMenuIdService.permissionCreateMenuId(roleModuleModelDto.getId());
        // 获取已有权限操作ID
        Result<List<Long>> operateId = iPermissionCreateSystemOperateIdService.permissionCreateSystemOperateId(roleModuleModelDto.getId());
        List<Long> list = menuId.getData();
        list.addAll(operateId.getData());
        return list;
    }
}
