// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 22:03
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.operate.IndexDto;
import os.api.v2.api.system.service.operate.IOperateIndexService;
import os.api.v2.api.system.vo.operate.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.menu.IMenuService;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;
import os.api.v2.model.service.system.vo.menuoperate.IndexModelVo;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo;

import java.util.*;
import java.util.stream.Collectors;

/**
 * os.api.v2.api.system.service.operate.impl.OperateIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 22:03
 */
@Service
public class OperateIndexServiceImpl implements IOperateIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menuoperate.IOperateIndexService iOperateIndexService;

    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<List<IndexDto>> index(IndexVo indexVo) throws UserException {
        List<MenuOperateModelDto> menuOperateModelDtoList = getMenuOperateModelDto(indexVo);
        List<Long> moduleIdList = menuOperateModelDtoList.stream().map(MenuOperateModelDto::getModuleId).collect(Collectors.toList());
        Map<Long, String> moduleMap = getModuleList(moduleIdList);
        List<Long> menuIdList = menuOperateModelDtoList.stream().map(MenuOperateModelDto::getMenuId).collect(Collectors.toList());
        Map<Long, String> menuMap = getMenuList(menuIdList);
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        return complete(menuOperateModelDtoList, moduleMap, menuMap, menuOperateList);
    }

    public List<MenuOperateModelDto> getMenuOperateModelDto(IndexVo indexVo) throws UserException {
        IndexModelVo indexModelVo = new IndexModelVo();
        BeanUtils.copyProperties(indexVo, indexModelVo);
        indexModelVo.setFieldArray(new String[]{
                "id",
                "module_id",
                "menu_id",
                "location",
                "type",
                "permission_identify",
                "name_en",
                "name_zh",
                "uri",
                "sorting"
        });
        Result<List<MenuOperateModelDto>> result = iOperateIndexService.index(indexModelVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException(result.getMessage());
        }
        return result.getData();
    }

    private Map<Long, String> getModuleList(List<Long> idList) {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setIdList(idList);
        moduleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        return result.getData().stream().collect(Collectors.toMap(ModuleModelDto::getId, ModuleModelDto::getNameZh));
    }

    private Map<Long, String> getMenuList(List<Long> idList) {
        MenuModelVo menuModelVo = new MenuModelVo();
        menuModelVo.setIdList(idList);
        menuModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<MenuModelDto>> result = iMenuService.getMenuList(menuModelVo);
        return result.getData().stream().collect(Collectors.toMap(MenuModelDto::getId, MenuModelDto::getNameZh));
    }

    private Result<List<IndexDto>> complete(List<MenuOperateModelDto> menuOperateModelDtoList, Map<Long, String> moduleMap, Map<Long, String> menuMap, List<Map<String, Object>> menuOperateList) {
        List<IndexDto> indexDtoList = new ArrayList<>();

        for (MenuOperateModelDto menuOperateModelDto: menuOperateModelDtoList) {
            IndexDto indexDto = new IndexDto();
            BeanUtils.copyProperties(menuOperateModelDto, indexDto);
            indexDto.setModuleNameZh(moduleMap.get(indexDto.getModuleId()));
            indexDto.setMenuNameZh(menuMap.get(indexDto.getMenuId()));
            indexDto.setOpts(menuOperateList);
            indexDtoList.add(indexDto);
        }

        return new Result<>(Result.SUCCESS, indexDtoList);
    }

    /**
     * getMenuOperateList
     * 
     * @param menuOperateIdList
     * @return List<Map<String,Object>>
     * @author 吴荣超
     * @date 22:29 2022/9/1
     */
    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableBodyListByIdList(menuOperateIdList);
    }

    /**
     * getMenuOperateIdList 
     *  
     * @return List<Long>
     * @author 吴荣超
     * @date 22:29 2022/9/1
     */
    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417150205952L);
        menuOperateServiceVo.setSystemMenuId(1102868720906162176L);
        Result<List<Long>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }
}
