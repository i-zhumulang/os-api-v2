// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-03 00:15
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.module;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.system.mapper.ModuleMapper;
import os.api.v2.model.impl.system.pojo.Module;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.module.ModuleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-03 00:15
 */
@DubboService(version = "2.0.0")
public class ModuleServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IModuleService {

    @Override
    public Result<List<ModuleModelDto>> getModuleByIdList(List<Integer> id, String[] fieldArray) {
        LambdaQueryWrapper<Module> queryWrapper = new FieldValuesUtils<>(Module.class, fieldArray).queryWrapper();
        queryWrapper.in(id != null, Module::getId, id);
        queryWrapper.orderByAsc(Module::getSorting);
        List<Module> modules = getBaseMapper().selectList(queryWrapper);
        List<ModuleModelDto> moduleModelDtoList = new ArrayList<>();
        for (Module module : modules) {
            ModuleModelDto moduleModelDto = new ModuleModelDto();
            BeanUtils.copyProperties(module, moduleModelDto);
            moduleModelDtoList.add(moduleModelDto);
        }
        return new Result<>(Result.SUCCESS, moduleModelDtoList);
    }

    @Override
    public Result<ModuleModelDto> getModuleDto(ModuleModelVo moduleModelVo, String[] fieldArray) {
        LambdaQueryWrapper<Module> queryWrapper = new FieldValuesUtils<>(Module.class, fieldArray).queryWrapper();
        queryWrapper.eq(moduleModelVo.getId() != null, Module::getId, moduleModelVo.getId());
        Module module = getBaseMapper().selectOne(queryWrapper);
        if (module == null) {
            return new Result<>(Result.FAILURE, "数据不存在", null);
        }
        ModuleModelDto moduleModelDto = new ModuleModelDto();
        BeanUtils.copyProperties(module, moduleModelDto);
        return new Result<>(Result.SUCCESS, moduleModelDto);
    }
}
