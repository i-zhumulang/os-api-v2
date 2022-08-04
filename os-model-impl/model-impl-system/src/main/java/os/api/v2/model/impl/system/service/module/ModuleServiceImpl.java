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
import os.api.v2.model.service.system.dto.module.ModuleDto;
import os.api.v2.model.service.system.service.module.IModuleService;

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
    public Result<List<ModuleDto>> getByIdList(List<Integer> id, String[] fieldArray) {
        LambdaQueryWrapper<Module> queryWrapper = new FieldValuesUtils<>(Module.class, fieldArray).queryWrapper();
        queryWrapper.in(id != null, Module::getId, id);
        queryWrapper.orderByAsc(Module::getSorting);
        List<Module> modules = getBaseMapper().selectList(queryWrapper);
        List<ModuleDto> moduleDtoList = new ArrayList<>();
        for (Module module : modules) {
            ModuleDto moduleDto = new ModuleDto();
            BeanUtils.copyProperties(module, moduleDto);
            moduleDtoList.add(moduleDto);
        }
        return new Result<>(Result.SUCCESS, moduleDtoList);
    }
}
