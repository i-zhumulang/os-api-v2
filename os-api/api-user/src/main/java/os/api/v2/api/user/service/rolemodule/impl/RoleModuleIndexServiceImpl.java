// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:25
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.rolemodule.IndexDataDto;
import os.api.v2.api.user.dto.rolemodule.IndexDto;
import os.api.v2.api.user.service.rolemodule.IRoleModuleIndexService;
import os.api.v2.api.user.vo.rolemodule.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemodule.IndexDataModelDto;
import os.api.v2.model.service.user.dto.rolemodule.IndexModelDto;
import os.api.v2.model.service.user.vo.rolemodule.IndexModelVo;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.service.service.user.service.role.IRoleService;
import os.api.v2.service.service.system.service.module.IModuleService;
import os.api.v2.service.service.user.vo.roleoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:25
 */
@Service
public class RoleModuleIndexServiceImpl implements IRoleModuleIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.rolemodule.IRoleModuleIndexService iRoleModuleIndexService;

    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected IRoleService iRoleService;

    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

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
        Result<IndexModelDto> result = iRoleModuleIndexService.index(indexModelVo);
        return result.getData();
    }

    private Result<IndexDto> complete(IndexModelDto indexModelDto) {
        IndexDto indexDto = new IndexDto();
        indexDto.setTotal(indexModelDto.getTotal());
        // 模块名称
        Result<Map<Long, String>> module = iModuleService.getModuleIdNameMap();
        // 角色名称
        Result<Map<Integer, String>> role = iRoleService.getRoleIdNameZhMap();
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);

        List<IndexDataDto> indexDataDtoList = new ArrayList<>();
        for (IndexDataModelDto indexDataModelDto : indexModelDto.getData()) {
            IndexDataDto indexDataDto = new IndexDataDto();
            BeanUtils.copyProperties(indexDataModelDto, indexDataDto);
            indexDataDto.setSystemModuleName(module.getData().get(indexDataDto.getSystemModuleId()));
            indexDataDto.setRoleName(role.getData().get(indexDataDto.getRoleId()));
            indexDataDto.setOpts(menuOperateList);
            indexDataDtoList.add(indexDataDto);
        }
        indexDto.setData(indexDataDtoList);
        return new Result<>(Result.SUCCESS, indexDto);
    }

    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417951318016L);
        menuOperateServiceVo.setSystemMenuId(1102873120315822080L);
        Result<List<Long>> result = iRoleOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableBodyListByIdList(menuOperateIdList);
    }
}
