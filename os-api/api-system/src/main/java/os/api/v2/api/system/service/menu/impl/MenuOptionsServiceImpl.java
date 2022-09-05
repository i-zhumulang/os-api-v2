// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-29 22:22
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.menu.IMenuOptionsService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;
import os.api.v2.service.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.menu.impl.MenuOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-29 22:22
 */
@Service
public class MenuOptionsServiceImpl implements IMenuOptionsService {
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

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
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417150205952L);
        menuOperateServiceVo.setSystemMenuId(1100177342397005824L);
        Result<List<Long>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
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
