// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 00:10
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.operate.CreateDto;
import os.api.v2.api.system.dto.operate.CreateMenuDto;
import os.api.v2.api.system.dto.operate.CreateModuleDto;
import os.api.v2.api.system.service.operate.IOperateEditService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.menu.IMenuService;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.service.operate.impl.OperateEditServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 00:10
 */
@Service
public class OperateEditServiceImpl implements IOperateEditService {
    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @Override
    public Result<CreateDto> edit() {
        List<CreateModuleDto> moduleList = getModuleList();
        List<CreateMenuDto> menuDtoList = getMenuList();
        return complete(moduleList, menuDtoList);
    }

    private List<CreateModuleDto> getModuleList() {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        List<CreateModuleDto> list = new ArrayList<>();
        for (ModuleModelDto moduleModelDto : result.getData()) {
            CreateModuleDto createModuleDto = new CreateModuleDto();
            createModuleDto.setId(moduleModelDto.getId());
            createModuleDto.setNameZh(moduleModelDto.getNameZh());
            createModuleDto.setMenu(new ArrayList<>());
            list.add(createModuleDto);
        }
        return list;
    }

    private List<CreateMenuDto> getMenuList() {
        MenuModelVo menuModelVo = new MenuModelVo();
        menuModelVo.setFieldArray(new String[]{
                "id",
                "parent_id",
                "module_id",
                "name_zh"
        });
        Result<List<MenuModelDto>> result = iMenuService.getMenuList(menuModelVo);
        List<CreateMenuDto> createMenuDtoList = new ArrayList<>();
        for (MenuModelDto menuModelDto : result.getData()) {
            CreateMenuDto createMenuDto = new CreateMenuDto();
            createMenuDto.setId(menuModelDto.getId());
            createMenuDto.setNameZh(menuModelDto.getNameZh());
            createMenuDto.setParentId(menuModelDto.getParentId());
            createMenuDto.setModuleId(menuModelDto.getModuleId());
            createMenuDto.setChildren(new ArrayList<>());
            createMenuDtoList.add(createMenuDto);
        }
        return process(createMenuDtoList);
    }

    public List<CreateMenuDto> process(List<CreateMenuDto> menuDtoList) {
        //存返回数据
        List<CreateMenuDto> totalType = new ArrayList<>();
        //使用map来装前面查到的所有数据
        Map<Long, CreateMenuDto> map = new HashMap<>();
        for (CreateMenuDto p : menuDtoList) {
            map.put(p.getId(), p);
        }
        //遍历所有类型，如果是最顶级父类型就直接装, 然后用这个父类型的children集合取装取当前数据
        for (CreateMenuDto p : menuDtoList) {
            if (p.getParentId() == 0) {
                totalType.add(p);
            } else {
                CreateMenuDto parents = map.get(p.getParentId());
                parents.getChildren().add(p);
            }
        }
        return totalType;
    }

    private Result<CreateDto> complete(List<CreateModuleDto> moduleList, List<CreateMenuDto> menuDtoList) {
        Map<Long, List<CreateMenuDto>> map = new HashMap<>();
        for (CreateMenuDto createMenuDto: menuDtoList) {
            List<CreateMenuDto> createMenuDtoList = map.get(createMenuDto.getModuleId());
            if (createMenuDtoList == null || createMenuDtoList.isEmpty()) {
                List<CreateMenuDto> list = new ArrayList<>();
                list.add(createMenuDto);
                map.put(createMenuDto.getModuleId(), list);
            } else {
                createMenuDtoList.add(createMenuDto);
            }
        }
        for (CreateModuleDto moduleDto: moduleList) {
            moduleDto.setMenu(map.get(moduleDto.getId()));
        }
        CreateDto createDto = new CreateDto();
        createDto.setModule(moduleList);
        return new Result<>(Result.SUCCESS, createDto);
    }
}
