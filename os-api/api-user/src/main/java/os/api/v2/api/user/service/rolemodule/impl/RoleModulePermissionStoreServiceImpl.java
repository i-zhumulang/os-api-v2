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

import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModulePermissionStoreService;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreMenuVo;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreOperateVo;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreRoleModuleVo;
import os.api.v2.api.user.vo.rolemodule.PermissionStoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.common.base.utils.IdWorkerUtils;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.rolemenu.IRoleMenuService;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.rolemenu.RoleMenuModelVo;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;
import os.api.v2.service.service.user.service.roleoperate.IPermissionCreateSystemOperateIdService;

import java.util.*;
import java.util.stream.Collectors;

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
    @DubboReference(version = "2.0.0")
    protected IRoleMenuService iRoleMenuService;
    @DubboReference(version = "2.0.0")
    protected IPermissionCreateSystemOperateIdService iPermissionCreateSystemOperateIdService;

    @Override
    public Result<String> permissionStore(PermissionStoreVo permissionStoreVo) throws UserException {
        RoleModuleModelDto roleModuleModelDto = getRoleModuleModelDto(permissionStoreVo.getRoleModule());
        // 获取已经拥有的菜单
        List<Long> permissionMenu = getPermissionMenu(roleModuleModelDto);
        // 获取已经删除、新增的菜单
        Map<String, Object> menuListMap = getCreateDestroyMenu(roleModuleModelDto, permissionStoreVo.getMenu(), permissionMenu);
        // 执行删除、新增操作

        // 获取已经拥有的操作
        List<Long> permissionOperate = getPermissionOperate(roleModuleModelDto);
        // 获取已经删除、新增的操作
        Map<String, Object> operateListMap = getCreateDestroyOperate(permissionStoreVo.getOperate(), permissionOperate);
        // 执行删除、新增操作
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

    private List<Long> getPermissionMenu(RoleModuleModelDto roleModuleModelDto) {
        // 获取已有权限菜单ID
        RoleMenuModelVo modelVo = new RoleMenuModelVo();
        modelVo.setRoleModuleId(roleModuleModelDto.getId());
        Result<List<Long>> result = iRoleMenuService.permission(modelVo);

        return result.getData();
    }

    private List<Long> getPermissionOperate(RoleModuleModelDto roleModuleModelDto) {
        // 获取已有权限操作ID
        Result<List<Long>> result =
                iPermissionCreateSystemOperateIdService.permissionCreateSystemOperateId(
                        roleModuleModelDto.getId()
                );
        return result.getData();
    }

    private Map<String, Object> getCreateDestroyMenu(RoleModuleModelDto roleModuleModelDto, List<PermissionStoreMenuVo> newList, List<Long> oldList) {
        List<Long> menuIdList = newList.stream().map(PermissionStoreMenuVo::getSystemMenuId).collect(Collectors.toList());
        Collection destroy = CollectionUtils.subtract(menuIdList, oldList);
        Collection insert = CollectionUtils.subtract(oldList, menuIdList);
        // 用于判断是否是子菜单
        Map<Long, Long> map = newList.stream().collect(Collectors.toMap(PermissionStoreMenuVo::getSystemMenuId, PermissionStoreMenuVo::getParentId));
        Map<String, Object> result = new HashMap<>();
        result.put("destroy", destroy);
        List<RoleMenuModelVo> roleMenuModelVoList = new ArrayList<>();
        for (Object menuId : insert) {
            RoleMenuModelVo roleMenuModelVo = new RoleMenuModelVo();
            roleMenuModelVo.setId(new IdWorkerUtils().nextId());
            roleMenuModelVo.setRoleModuleId(roleModuleModelDto.getId());
            roleMenuModelVo.setRoleId(roleModuleModelDto.getRoleId());
            roleMenuModelVo.setSystemModuleId(roleModuleModelDto.getSystemModuleId());
            roleMenuModelVo.setSystemMenuId((Long) menuId);
            Long parentId = map.get(menuId);
            if (Objects.equals(parentId, 0L)) {
                roleMenuModelVo.setGrade(0);
            } else {
                roleMenuModelVo.setGrade(1);
            }
            roleMenuModelVoList.add(roleMenuModelVo);
        }
        result.put("insert", roleMenuModelVoList);
        return result;
    }

    private Map<String, Object> getCreateDestroyOperate(List<PermissionStoreOperateVo> newList, List<Long> oldList) {
        return null;
    }
}
