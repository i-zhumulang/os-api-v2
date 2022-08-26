// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 08:08
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.module.EditDto;
import os.api.v2.api.system.service.module.IUpdateService;
import os.api.v2.api.system.vo.module.ModuleVo;
import os.api.v2.api.system.vo.module.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.service.module.IModuleService;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;

import java.util.List;
import java.util.Objects;

/**
 * os.api.v2.api.system.service.module.impl.UpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 08:08
 */
@Service
public class UpdateServiceImpl implements IUpdateService {

    @DubboReference(version = "2.0.0")
    protected IModuleService iModuleService;

    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.module.IUpdateService iUpdateService;

    @Override
    public Result<EditDto> edit(ModuleVo moduleVo) {
        String[] fieldArray = {
                "id",
                "name_en",
                "name_zh",
                "domain",
                "home_page",
                "sorting"
        };
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setId(moduleVo.getId());
        moduleModelVo.setFieldArray(fieldArray);
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);

        if (Objects.equals(Result.FAILURE, result.getFlag())) {
            return new Result<>(result.getFlag(), null);
        }

        EditDto editDto = new EditDto();
        BeanUtils.copyProperties(result.getData().stream().findFirst(), editDto);
        return new Result<>(result.getFlag(), editDto);
    }

    @Override
    public Result<ModuleModelDto> update(UpdateVo updateVo) {
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        BeanUtils.copyProperties(updateVo, moduleModelVo);
        Result<ModuleModelDto> result = iUpdateService.update(moduleModelVo);
        return result;
    }
}
