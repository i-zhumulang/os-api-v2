// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 22:21
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemenu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.ModuleMenuMapper;
import os.api.v2.model.impl.user.pojo.RoleMenu;
import os.api.v2.model.service.user.service.rolemenu.IRoleMenuService;
import os.api.v2.model.service.user.vo.rolemenu.RoleMenuModelVo;

import java.util.List;
import java.util.stream.Collectors;

/**
 * os.api.v2.model.impl.user.service.rolemenu.ModuleMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 22:21
 */
@DubboService(version = "2.0.0")
public class RoleMenuServiceImpl extends ServiceImpl<ModuleMenuMapper, RoleMenu> implements IRoleMenuService {
    @Override
    public Result<List<Long>> permission(RoleMenuModelVo roleMenuModelVo) {
        String[] fieldArray = {"system_menu_id"};
        LambdaQueryWrapper<RoleMenu> queryWrapper = new FieldValuesUtils<>(RoleMenu.class, fieldArray).queryWrapper();
        queryWrapper.eq(RoleMenu::getRoleId, roleMenuModelVo.getRoleId());
        queryWrapper.eq(RoleMenu::getSystemModuleId, roleMenuModelVo.getSystemModuleId());
        List<RoleMenu> roleMenus = getBaseMapper().selectList(queryWrapper);
        if (roleMenus.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<Long> collect = roleMenus.stream().map(RoleMenu::getSystemMenuId).collect(Collectors.toList());
        return new Result<>(Result.SUCCESS, collect);
    }
}