// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 22:21
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.modulemenu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.ModuleMenuMapper;
import os.api.v2.model.impl.user.pojo.ModuleMenu;
import os.api.v2.model.service.user.service.modulemenu.IModuleMenuService;
import os.api.v2.model.service.user.vo.modulemenu.ModuleMenuModelVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * os.api.v2.model.impl.user.service.modulemenu.ModuleMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 22:21
 */
@DubboService(version = "2.0.0")
public class ModuleMenuServiceImpl extends ServiceImpl<ModuleMenuMapper, ModuleMenu> implements IModuleMenuService {
    @Override
    public Result<List<Long>> permission(ModuleMenuModelVo moduleMenuModelVo) {
        String[] fieldArray = {"system_menu_id"};
        LambdaQueryWrapper<ModuleMenu> queryWrapper = new FieldValuesUtils<>(ModuleMenu.class, fieldArray).queryWrapper();
        queryWrapper.eq(ModuleMenu::getRoleId, moduleMenuModelVo.getRoleId());
        queryWrapper.eq(ModuleMenu::getSystemModuleId, moduleMenuModelVo.getSystemModuleId());
        List<ModuleMenu> moduleMenus = getBaseMapper().selectList(queryWrapper);
        if (moduleMenus.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<Long> collect = moduleMenus.stream().map(ModuleMenu::getSystemMenuId).collect(Collectors.toList());
        return new Result<>(Result.SUCCESS, collect);
    }
}