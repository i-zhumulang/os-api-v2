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
import os.api.v2.service.service.system.service.module.IModuleService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @Override
    public Result<IndexDto> index(IndexVo indexVo) {
        IndexModelVo indexModelVo = new IndexModelVo();
        BeanUtils.copyProperties(indexVo, indexModelVo);
        Result<IndexModelDto> result = iRoleModuleIndexService.index(indexModelVo);
        IndexDto indexDto = new IndexDto();
        indexDto.setTotal(result.getData().getTotal());
        if (indexDto.getTotal() == 0) {
            return new Result<>(Result.SUCCESS, indexDto);
        }
        Result<Map<Long, String>> module = iModuleService.getModuleIdNameMap();
        List<IndexDataDto> indexDataDtoList = new ArrayList<>();
        for (IndexDataModelDto indexDataModelDto : result.getData().getData()) {
            IndexDataDto indexDataDto = new IndexDataDto();
            BeanUtils.copyProperties(indexDataModelDto, indexDataDto);
            indexDataDto.setSystemModuleName(module.getData().get(indexDataDto.getSystemModuleId()));
            indexDataDtoList.add(indexDataDto);
        }
        indexDto.setData(indexDataDtoList);
        return new Result<>(Result.SUCCESS, indexDto);
    }
}
