// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:10
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemodule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.RoleModuleMapper;
import os.api.v2.model.impl.user.pojo.RoleModule;
import os.api.v2.model.service.user.dto.rolemodule.IndexModelDto;
import os.api.v2.model.service.user.dto.rolemodule.IndexDataModelDto;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleIndexService;
import os.api.v2.model.service.user.vo.rolemodule.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.rolemodule.RoleModuleIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:10
 */
@DubboService(version = "2.0.0")
public class RoleModuleIndexServiceImpl extends ServiceImpl<RoleModuleMapper, RoleModule> implements IRoleModuleIndexService {
    @Override
    public Result<IndexModelDto> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<RoleModule> queryWrapper = queryWrapper(indexModelVo);
        Page<RoleModule> page = new Page<>();
        Page<RoleModule> modulePage = getBaseMapper().selectPage(page, queryWrapper);
        IndexModelDto indexModelDto = new IndexModelDto();
        indexModelDto.setTotal(modulePage.getTotal());

        if (indexModelDto.getTotal() == 0) {
            return new Result<>(Result.SUCCESS, indexModelDto);
        }
        List<IndexDataModelDto> indexDataModelDtoList = new ArrayList<>();
        List<RoleModule> roleModuleList = modulePage.getRecords();
        for (RoleModule roleModule : roleModuleList) {
            IndexDataModelDto indexDataModelDto = new IndexDataModelDto();
            BeanUtils.copyProperties(roleModule, indexDataModelDto);
            indexDataModelDtoList.add(indexDataModelDto);
        }
        indexModelDto.setData(indexDataModelDtoList);
        return new Result<>(Result.SUCCESS, indexModelDto);
    }

    private LambdaQueryWrapper<RoleModule> queryWrapper(IndexModelVo indexModelVo) {
        String[] fieldArray = new String[]{
                "id",
                "role_id",
                "system_module_id"
        };
        LambdaQueryWrapper<RoleModule> queryWrapper = new FieldValuesUtils<>(RoleModule.class, fieldArray).queryWrapper();
        queryWrapper.eq(indexModelVo.getRoleId() != null, RoleModule::getRoleId, indexModelVo.getRoleId());
        queryWrapper.eq(indexModelVo.getSystemModuleId() != null, RoleModule::getSystemModuleId, indexModelVo.getSystemModuleId());
        return queryWrapper;
    }
}
