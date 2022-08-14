// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 15:56
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.module;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.ModuleMapper;
import os.api.v2.model.impl.system.pojo.Module;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.module.IUpdateService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

/**
 * os.api.v2.model.impl.system.service.module.UpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 15:56
 */
@DubboService(version = "2.0.0")
public class UpdateServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IUpdateService {
    @Override
    public Result<ModuleModelDto> update(ModuleModelVo moduleModelVo) {
        Module entity = new Module();
        BeanUtils.copyProperties(moduleModelVo, entity);
        int i = getBaseMapper().updateById(entity);
        if (i == 0) {
            return new Result<>(Result.FAILURE, "更新失败");
        }
        Module module = getBaseMapper().selectById(moduleModelVo.getId());
        ModuleModelDto moduleModelDto = new ModuleModelDto();
        BeanUtils.copyProperties(module, moduleModelDto);
        return new Result<>(Result.SUCCESS, "更新成功", moduleModelDto);
    }
}
