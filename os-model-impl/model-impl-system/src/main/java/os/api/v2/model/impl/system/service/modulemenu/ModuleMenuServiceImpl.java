// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 00:54
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.modulemenu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.system.mapper.ModuleMenuMapper;
import os.api.v2.model.impl.system.pojo.ModuleMenu;
import os.api.v2.model.service.system.dto.modulemenu.ModuleMenuModelDto;
import os.api.v2.model.service.system.service.modulemenu.IModuleMenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.modulemenu.ModuleMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 00:54
 */
@DubboService(version = "2.0.0")
public class ModuleMenuServiceImpl extends ServiceImpl<ModuleMenuMapper, ModuleMenu> implements IModuleMenuService {
    /**
     * permission
     *
     * @param idList
     * @param fieldArray
     * @return Result<List<ModuleMenuModelDto>>
     * @author 吴荣超
     * @date 1:05 2022/8/6
     */
    @Override
    public Result<List<ModuleMenuModelDto>> permission(List<Integer> idList, String[] fieldArray) {
        LambdaQueryWrapper<ModuleMenu> queryWrapper = new FieldValuesUtils<>(ModuleMenu.class, fieldArray).queryWrapper();
        queryWrapper.in(ModuleMenu::getId, idList);
        List<ModuleMenu> moduleMenus = getBaseMapper().selectList(queryWrapper);
        if (moduleMenus.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<ModuleMenuModelDto> moduleMenuModelDtoList = new ArrayList<>();

        for (ModuleMenu moduleMenu : moduleMenus) {
            ModuleMenuModelDto moduleMenuModelDto = new ModuleMenuModelDto();
            BeanUtils.copyProperties(moduleMenu, moduleMenuModelDto);
            moduleMenuModelDtoList.add(moduleMenuModelDto);
        }
        return new Result<>(Result.SUCCESS, moduleMenuModelDtoList);
    }
}
