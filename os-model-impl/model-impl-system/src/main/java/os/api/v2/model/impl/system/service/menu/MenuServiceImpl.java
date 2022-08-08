// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 23:32
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.system.mapper.MenuMapper;
import os.api.v2.model.impl.system.pojo.Menu;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.service.menu.IMenuService;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.menu.MenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 23:32
 */
@DubboService(version = "2.0.0")
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {
    @Override
    public Result<List<MenuModelDto>> permission(List<Integer> idList, String[] fieldArray) {
        LambdaQueryWrapper<Menu> queryWrapper = new FieldValuesUtils<>(Menu.class, fieldArray).queryWrapper();
        queryWrapper.in(Menu::getId, idList);
        List<Menu> menus = getBaseMapper().selectList(queryWrapper);
        if (menus.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<MenuModelDto> menuModelDtoList = new ArrayList<>();

        for (Menu moduleMenu : menus) {
            MenuModelDto menuModelDto = new MenuModelDto();
            BeanUtils.copyProperties(moduleMenu, menuModelDto);
            menuModelDtoList.add(menuModelDto);
        }
        return new Result<>(Result.SUCCESS, menuModelDtoList);
    }
}
