// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:56
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.modulemenu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.modulemenu.IndexDto;
import os.api.v2.api.user.dto.modulemenu.IndexDataDto;
import os.api.v2.api.user.service.modulemenu.IModuleMenuIndexService;
import os.api.v2.api.user.vo.modulemenu.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.modulemenu.IndexModelDto;
import os.api.v2.model.service.user.dto.modulemenu.IndexDataModelDto;
import os.api.v2.model.service.user.vo.modulemenu.IndexModelVo;
import os.api.v2.service.service.system.service.menu.IMenuService;
import os.api.v2.service.service.system.service.module.IModuleService;
import os.api.v2.service.service.user.service.role.IRoleService;

import java.util.*;

/**
 * os.api.v2.api.user.service.modulemenu.impl.ModuleMenuIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:56
 */
@Service
public class ModuleMenuIndexServiceImpl implements IModuleMenuIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.modulemenu.IModuleMenuIndexService iModuleMenuIndexService;

    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @DubboReference(version = "2.0.0")
    protected IRoleService iRoleService;

    @Override
    public Result<IndexDto> index(IndexVo indexVo) {
        IndexModelDto indexModelDto = getIndexModelDto(indexVo);
        IndexDto indexDto = new IndexDto();
        indexDto.setTotal(indexModelDto.getTotal());
        if (indexDto.getTotal() == 0) {
            indexDto.setData(Collections.emptyList());
            return new Result<>(Result.SUCCESS, indexDto);
        }
        return complete(indexModelDto);
    }

    private IndexModelDto getIndexModelDto(IndexVo indexVo) {
        IndexModelVo indexModelVo = new IndexModelVo();
        BeanUtils.copyProperties(indexVo, indexModelVo);
        Result<IndexModelDto> result = iModuleMenuIndexService.index(indexModelVo);
        return result.getData();
    }

    private Result<IndexDto> complete(IndexModelDto indexModelDto) {
        IndexDto indexDto = new IndexDto();
        indexDto.setTotal(indexModelDto.getTotal());
        // 模块名称
        Result<Map<Long, String>> module = iModuleService.getModuleIdNameMap();
        // 角色名称
        Result<Map<Integer, String>> role = iRoleService.getRoleIdNameZhMap();
        // 菜单名称
        Result<Map<Long, String>> menu = iMenuService.getMenuIdNameZhMap();

        List<IndexDataDto> indexDataDtoList = new ArrayList<>();
        for (IndexDataModelDto indexDataModelDto : indexModelDto.getData()) {
            IndexDataDto indexDataDto = new IndexDataDto();
            BeanUtils.copyProperties(indexDataModelDto, indexDataDto);
            indexDataDto.setSystemModuleName(module.getData().get(indexDataDto.getSystemModuleId()));
            indexDataDto.setRoleName(role.getData().get(indexDataDto.getRoleId()));
            indexDataDto.setSystemMenuName(menu.getData().get(indexDataDto.getSystemMenuId()));
            indexDataDtoList.add(indexDataDto);
        }
        indexDto.setData(indexDataDtoList);
        return new Result<>(Result.SUCCESS, indexDto);
    }
}
