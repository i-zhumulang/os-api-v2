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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

    @Override
    public Result<List<IndexDto>> index(IndexVo indexVo) throws UserException {
        List<MenuOperateModelDto> menuOperateModelDtoList = getMenuOperateModelDto(indexVo);
        List<Long> moduleIdList = menuOperateModelDtoList.stream().map(MenuOperateModelDto::getModuleId).collect(Collectors.toList());
        Map<Long, String> moduleMap = getModuleList(moduleIdList);
        List<Long> menuIdList = menuOperateModelDtoList.stream().map(MenuOperateModelDto::getMenuId).collect(Collectors.toList());
        Map<Long, String> menuMap = getMenuList(menuIdList);
        return complete(menuOperateModelDtoList, moduleMap, menuMap);
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
    private Result<List<IndexDto>> complete(List<MenuOperateModelDto> menuOperateModelDtoList, Map<Long, String> moduleMap, Map<Long, String> menuMap) {
        List<IndexDto> indexDtoList = new ArrayList<>();

        for (MenuOperateModelDto menuOperateModelDto: menuOperateModelDtoList) {
            IndexDto indexDto = new IndexDto();
            BeanUtils.copyProperties(menuOperateModelDto, indexDto);
            indexDto.setModuleNameZh(moduleMap.get(indexDto.getModuleId()));
            indexDto.setMenuNameZh(menuMap.get(indexDto.getMenuId()));
            indexDtoList.add(indexDto);
        }

        return new Result<>(Result.SUCCESS, indexDtoList);
    }
}
