// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 23:06
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.api.user.dto.rolemodule.CreateDto;
import os.api.v2.api.user.dto.rolemodule.ModuleDataDto;
import os.api.v2.api.user.dto.rolemodule.RoleDataDto;
import os.api.v2.api.user.service.rolemodule.IRoleModuleCreateService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.service.role.IRoleService;
import os.api.v2.model.service.user.vo.role.RoleModelVo;
import os.api.v2.service.service.system.dto.module.ModuleServiceDto;
import os.api.v2.service.service.system.service.module.IModuleService;
import os.api.v2.service.service.system.vo.module.ModuleServiceVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleCreateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 23:06
 */
@DubboService(version = "2.0.0")
public class RoleModuleCreateServiceImpl implements IRoleModuleCreateService {
    @DubboReference(version = "2.0.0")
    protected IRoleService iRoleService;
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @Override
    public Result<CreateDto> create() {
        CreateDto createDto = new CreateDto();
        createDto.setRole(role());
        createDto.setModule(module());
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
        for (RoleModelDto roleModelDto: roleList.getData()) {
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
        for (ModuleServiceDto moduleServiceDto: moduleIdNameList.getData()) {
            ModuleDataDto moduleDataDto = new ModuleDataDto();
            BeanUtils.copyProperties(moduleServiceDto, moduleDataDto);
            moduleDataDtoList.add(moduleDataDto);
        }
        return moduleDataDtoList;
    }
}
