// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 12:55
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.menu.CreateDto;
import os.api.v2.api.system.service.menu.IMenuEditService;
import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.menu.IMenuService;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * os.api.v2.api.system.service.menu.impl.MenuEditServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 12:55
 */
@Service
public class MenuEditServiceImpl implements IMenuEditService {
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @Override
    public Result<CreateDto> edit(MenuVo menuVo) {
        List<ModuleModelDto> moduleModelDtoList = moduleModelDtoList();
        Map<Long, List<MenuModelDto>> longListMap = menuModelDtoList();

        Map<Long, Map<String, Object>> map = new HashMap<>();
        for (ModuleModelDto moduleModelDto: moduleModelDtoList) {
            Map<String, Object> objectMap = new HashMap<>();
            objectMap.put("id", moduleModelDto.getId());
            objectMap.put("nameZh", moduleModelDto.getNameZh());
            objectMap.put("menus", longListMap.get(moduleModelDto.getId()));
            map.put(moduleModelDto.getId(), objectMap);
        }
        CreateDto createDto = new CreateDto();
        createDto.setModules(map);
        return new Result<>(Result.SUCCESS, createDto);
    }

    private List<ModuleModelDto> moduleModelDtoList() {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        return result.getData();
    }

    private Map<Long, List<MenuModelDto>> menuModelDtoList() {
        MenuModelVo menuModelVo = new MenuModelVo();
        menuModelVo.setParentId(0L);
        menuModelVo.setFieldArray(new String[]{
                "id",
                "module_id",
                "name_zh",
        });
        Result<List<MenuModelDto>> result = iMenuService.getMenuList(menuModelVo);

        return result.getData()
                .stream()
                .filter(Objects::nonNull)
                .filter(menuModelDto -> Objects.nonNull(menuModelDto.getModuleId()))
                .collect(Collectors.groupingBy(MenuModelDto::getModuleId));
    }
}
