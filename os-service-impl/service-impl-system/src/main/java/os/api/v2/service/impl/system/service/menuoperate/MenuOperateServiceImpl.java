// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-12-21 23:03
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system.service.menuoperate;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.vo.menuoperate.MenuOperateModelVo;
import os.api.v2.service.service.system.dto.menuoperate.MenuOperateServiceDto;
import os.api.v2.service.service.system.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.system.vo.menuoperate.MenuOperateServiceVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.service.impl.system.service.menuoperate.IMenuOperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-12-21 23:03
 */
@DubboService(version = "2.0.0")
public class MenuOperateServiceImpl implements IMenuOperateService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menuoperate.IMenuOperateService iMenuOperateService;

    @Override
    public Result<List<MenuOperateServiceDto>> getMenuOperateList(MenuOperateServiceVo serviceVo) {
        MenuOperateModelVo modelVo = new MenuOperateModelVo();
        modelVo.setId(serviceVo.getId());
        modelVo.setIdList(serviceVo.getIdList());
        modelVo.setMenuId(serviceVo.getMenuId());
        modelVo.setMenuIdList(serviceVo.getMenuIdList());
        modelVo.setModuleId(serviceVo.getModuleId());
        modelVo.setModuleIdList(serviceVo.getModuleIdList());
        modelVo.setFieldArray(new String[]{"id", "menu_id", "module_id", "name_zh"});

        Result<List<MenuOperateModelDto>> result = iMenuOperateService.getMenuOperateList(modelVo);

        List<MenuOperateServiceDto> serviceDtoList = new ArrayList<>();

        if (Result.FAILURE.equals(result.getFlag())) {
            return new Result<>(Result.FAILURE, "暂无数据", serviceDtoList);
        }

        for (MenuOperateModelDto modelDto : result.getData()) {
            MenuOperateServiceDto serviceDto = new MenuOperateServiceDto();
            BeanUtils.copyProperties(modelDto, serviceDto);
            serviceDtoList.add(serviceDto);
        }
        return new Result<>(Result.SUCCESS, serviceDtoList);
    }
}
