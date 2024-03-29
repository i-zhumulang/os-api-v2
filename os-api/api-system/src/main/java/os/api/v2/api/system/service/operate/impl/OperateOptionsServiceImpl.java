// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-01 22:44
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.operate.IOperateOptionsService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.service.service.user.vo.roleoperate.RoleOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.operate.impl.OperateOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-01 22:44
 */
@Service
public class OperateOptionsServiceImpl implements IOperateOptionsService {
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<Map<String, Object>> options() {
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        Map<String, Object> map = new HashMap<>();
        map.put("operate", menuOperateList);
        List<ModuleModelDto> moduleModelDtoList = getModuleModelDtoList();
        map.put("module", moduleModelDtoList);
        return new Result<>(Result.SUCCESS, map);
    }
    /**
     * 获取数据操作权限ID
     *
     * @return List<Long>
     * @author 吴荣超
     * @date 22:25 2022/8/29
     */
    private List<Long> getMenuOperateIdList() {
        RoleOperateServiceVo roleOperateServiceVo = new RoleOperateServiceVo();
        roleOperateServiceVo.setRoleId(1);
        roleOperateServiceVo.setSystemModuleId(1100176417150205952L);
        roleOperateServiceVo.setSystemMenuId(1102868720906162176L);
        Result<List<Long>> result = iRoleOperateService.getSystemMenuOperateIdList(roleOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    /**
     * getMenuOperateList
     *
     * @param menuOperateIdList
     * @return List<Map<String,Object>>
     * @author 吴荣超
     * @date 22:25 2022/8/29
     */
    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableHeadListByIdList(menuOperateIdList);
    }

    /**
     * getModuleModelDtoList
     *
     * @return List<ModuleModelDto>
     * @author 吴荣超
     * @date 22:28 2022/8/29
     */
    private List<ModuleModelDto> getModuleModelDtoList() {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        return result.getData();
    }
}
