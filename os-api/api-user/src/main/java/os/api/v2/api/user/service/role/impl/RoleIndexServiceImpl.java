// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:22
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.role.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.role.IndexDataDto;
import os.api.v2.api.user.dto.role.IndexDto;
import os.api.v2.api.user.service.role.IRoleIndexService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.vo.role.IndexModelVo;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.roleoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.user.service.role.impl.RoleIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:22
 */
@Service
public class RoleIndexServiceImpl implements IRoleIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.role.IRoleIndexService iRoleIndexService;
    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<IndexDto> index() {
        // 获取数据列表
        List<RoleModelDto> roleModelDtoList = getRoleModelDtoList();
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        // 完善数据
        return complete(roleModelDtoList, menuOperateList);
    }

    private List<RoleModelDto> getRoleModelDtoList() {
        IndexModelVo indexModelVo = new IndexModelVo();
        indexModelVo.setFieldArray(new String[]{});
        Result<List<RoleModelDto>> result = iRoleIndexService.index(indexModelVo);
        return result.getData();
    }

    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417951318016L);
        menuOperateServiceVo.setSystemMenuId(1102872407070232576L);
        Result<List<Long>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
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
        return iGetListByIdListService.getTableHeadListByIdList(menuOperateIdList);
    }

    private Result<IndexDto> complete(List<RoleModelDto> roleModelDtoList, List<Map<String, Object>> menuOperateList) {
        IndexDto indexDto = new IndexDto();
        List<IndexDataDto> indexDataDtoList = new ArrayList<>();
        for (RoleModelDto roleModelDto: roleModelDtoList) {
            IndexDataDto indexDataDto = new IndexDataDto();
            BeanUtils.copyProperties(roleModelDto, indexDataDto);
            indexDataDtoList.add(indexDataDto);
        }
        indexDto.setTotal((long) roleModelDtoList.size());
        indexDto.setData(indexDataDtoList);
        return new Result<>(Result.SUCCESS, indexDto);
    }
}
