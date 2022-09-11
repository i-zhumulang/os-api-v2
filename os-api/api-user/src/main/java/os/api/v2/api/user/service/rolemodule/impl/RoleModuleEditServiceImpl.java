// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 18:01
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.rolemodule.CreateDto;
import os.api.v2.api.user.dto.rolemodule.ModuleDataDto;
import os.api.v2.api.user.dto.rolemodule.RoleDataDto;
import os.api.v2.api.user.dto.rolemodule.RoleModuleDataDto;
import os.api.v2.api.user.service.rolemodule.IRoleModuleEditService;
import os.api.v2.api.user.vo.rolemodule.EditVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.role.IRoleService;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.role.RoleModelVo;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;
import os.api.v2.service.service.system.dto.module.ModuleServiceDto;
import os.api.v2.service.service.system.service.module.IModuleService;
import os.api.v2.service.service.system.vo.module.ModuleServiceVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleEditServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 18:01
 */
@Service
public class RoleModuleEditServiceImpl implements IRoleModuleEditService {
    @DubboReference(version = "2.0.0")
    protected IRoleService iRoleService;
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IRoleModuleService iRoleModuleService;

    @Override
    public Result<CreateDto> edit(EditVo editVo) {
        CreateDto createDto = new CreateDto();
        createDto.setRole(role());
        createDto.setModule(module());
        createDto.setData(roleModule(editVo));
        return new Result<>(Result.SUCCESS, createDto);
    }

    private List<RoleDataDto> role() {
        RoleModelVo roleModelVo = new RoleModelVo();
        roleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<RoleModelDto>> roleList = iRoleService.getRoleList(roleModelVo);
        List<RoleDataDto> roleDataDtoList = new ArrayList<>();
        for (RoleModelDto roleModelDto : roleList.getData()) {
            RoleDataDto roleDataDto = new RoleDataDto();
            BeanUtils.copyProperties(roleModelDto, roleDataDto);
            roleDataDtoList.add(roleDataDto);
        }
        return roleDataDtoList;
    }

    private List<ModuleDataDto> module() {
        ModuleServiceVo moduleServiceVo = new ModuleServiceVo();
        Result<List<ModuleServiceDto>> moduleIdNameList = iModuleService.getModuleIdNameList(moduleServiceVo);
        List<ModuleDataDto> moduleDataDtoList = new ArrayList<>();
        for (ModuleServiceDto moduleServiceDto : moduleIdNameList.getData()) {
            ModuleDataDto moduleDataDto = new ModuleDataDto();
            BeanUtils.copyProperties(moduleServiceDto, moduleDataDto);
            moduleDataDtoList.add(moduleDataDto);
        }
        return moduleDataDtoList;
    }

    private RoleModuleDataDto roleModule(EditVo editVo) {
        RoleModuleModelVo roleModuleModelVo = new RoleModuleModelVo();
        roleModuleModelVo.setId(editVo.getId());
        roleModuleModelVo.setFieldArray(new String[]{
                "id",
                "role_id",
                "system_module_id"
        });
        Result<RoleModuleModelDto> result = iRoleModuleService.getSingle(roleModuleModelVo);
        System.out.println(result);
        RoleModuleDataDto roleModuleDataDto = new RoleModuleDataDto();
        BeanUtils.copyProperties(result.getData(), roleModuleDataDto);
        return roleModuleDataDto;
    }
}
