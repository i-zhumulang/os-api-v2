// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 20:13
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system.service.module;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.vo.module.ModuleModelVo;
import os.api.v2.service.service.system.dto.module.ModuleServiceDto;
import os.api.v2.service.service.system.service.module.IModuleService;
import os.api.v2.service.service.system.vo.module.ModuleServiceVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.system.service.module.ModuleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 20:13
 */
@DubboService(version = "2.0.0")
public class ModuleServiceImpl implements IModuleService {

    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.module.IModuleService iModuleService;

    @Override
    public Result<List<ModuleServiceDto>> getModuleByIdList(ModuleServiceVo moduleServiceVo) {
        String[] fieldArray = {
                "id",
                "name_en",
                "name_zh",
                "domain",
                "home_page"
        };
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setIdList(moduleServiceVo.getIdList());
        moduleModelVo.setFieldArray(fieldArray);
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);

        List<ModuleServiceDto> moduleServiceDtoList = new ArrayList<>();

        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), result.getMessage(), moduleServiceDtoList);
        }

        for (ModuleModelDto moduleModelDto : result.getData()) {
            ModuleServiceDto moduleServiceDto = new ModuleServiceDto();
            BeanUtils.copyProperties(moduleModelDto, moduleServiceDto);
            moduleServiceDtoList.add(moduleServiceDto);
        }

        return new Result<>(Result.SUCCESS, moduleServiceDtoList);
    }

    @Override
    public Result<Map<Long, String>> getModuleIdNameMap() {
        String[] fieldArray = {
                "id",
                "name_zh",
        };
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setFieldArray(fieldArray);
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        Map<Long, String> idName = result.getData()
                .stream()
                .collect(Collectors.toMap(ModuleModelDto::getId, ModuleModelDto::getNameZh));
        return new Result<>(Result.SUCCESS, idName);
    }

    @Override
    public Result<List<ModuleServiceDto>> getModuleIdNameList(ModuleServiceVo moduleServiceVo) {
        String[] fieldArray = {
                "id",
                "name_zh",
        };
        ModuleModelVo moduleModelVo = new ModuleModelVo();
        moduleModelVo.setFieldArray(fieldArray);
        Result<List<ModuleModelDto>> result = iModuleService.getModuleList(moduleModelVo);
        List<ModuleServiceDto> moduleServiceDtoList = new ArrayList<>();

        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), result.getMessage(), moduleServiceDtoList);
        }

        for (ModuleModelDto moduleModelDto : result.getData()) {
            ModuleServiceDto moduleServiceDto = new ModuleServiceDto();
            BeanUtils.copyProperties(moduleModelDto, moduleServiceDto);
            moduleServiceDtoList.add(moduleServiceDto);
        }

        return new Result<>(Result.SUCCESS, moduleServiceDtoList);
    }
}