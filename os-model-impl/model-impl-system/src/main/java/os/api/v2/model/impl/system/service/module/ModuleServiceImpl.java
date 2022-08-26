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
    public Result<String> destroy(ModuleModelVo moduleModelVo) {
        int result = getBaseMapper().deleteById(moduleModelVo.getId());
        if (result > 0) {
            return new Result<>(Result.SUCCESS, "删除成功");
        }
        return new Result<>(Result.FAILURE, "删除失败");
    }

    @Override
    public Result<List<ModuleModelDto>> getModuleList(ModuleModelVo moduleModelVo) {
        LambdaQueryWrapper<Module> queryWrapper = new FieldValuesUtils<>(Module.class, moduleModelVo.getFieldArray()).queryWrapper();
        queryWrapper.eq(moduleModelVo.getId() != null, Module::getId, moduleModelVo.getId());
        queryWrapper.in(moduleModelVo.getIdList() != null, Module::getId, moduleModelVo.getIdList());
        queryWrapper.orderByAsc(Module::getSorting);
        List<Module> modules = getBaseMapper().selectList(queryWrapper);
        if (modules.isEmpty()) {
            return new Result<>(Result.FAILURE, "数据不存在");
        }
        List<ModuleModelDto> moduleModelDtoList = new ArrayList<>();
        for (Module module : modules) {
            ModuleModelDto moduleModelDto = new ModuleModelDto();
            BeanUtils.copyProperties(module, moduleModelDto);
            moduleModelDtoList.add(moduleModelDto);
        }
        return new Result<>(Result.SUCCESS, moduleModelDtoList);
    }
}
