// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 18:36
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
import os.api.v2.model.service.system.service.module.IIndexService;
import os.api.v2.model.service.system.vo.module.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.module.IndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 18:36
 */
@DubboService(version = "2.0.0")
public class IndexServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IIndexService {
    @Override
    public Result<List<ModuleModelDto>> index(IndexModelVo indexModelVo, String[] fieldArray) {
        LambdaQueryWrapper<Module> queryWrapper = new FieldValuesUtils<>(Module.class, fieldArray).queryWrapper();
        queryWrapper.orderByAsc(Module::getSorting);
        List<Module> modules = getBaseMapper().selectList(queryWrapper);
        if (modules.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
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
