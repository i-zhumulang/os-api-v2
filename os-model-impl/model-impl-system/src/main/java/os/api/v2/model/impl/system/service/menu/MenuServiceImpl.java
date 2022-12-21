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
import os.api.v2.model.service.system.vo.menu.MenuModelVo;

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
    public Result<String> destroy(MenuModelVo menuModelVo) {
        int result = getBaseMapper().deleteById(menuModelVo.getId());
        if (result > 0) {
            return new Result<>(Result.SUCCESS, "删除成功");
        }
        return new Result<>(Result.FAILURE, "删除失败");
    }

    @Override
    public Result<List<MenuModelDto>> getMenuList(MenuModelVo menuModelVo) {
        LambdaQueryWrapper<Menu> queryWrapper = new FieldValuesUtils<>(Menu.class, menuModelVo.getFieldArray()).queryWrapper();

        // id查询
        queryWrapper.eq(menuModelVo.getId() != null, Menu::getId, menuModelVo.getId());
        queryWrapper.in(menuModelVo.getIdList() != null, Menu::getId, menuModelVo.getIdList());
        // module id查询
        queryWrapper.eq(menuModelVo.getModuleId() != null, Menu::getModuleId,menuModelVo.getModuleId());
        queryWrapper.in(menuModelVo.getModuleIdList() != null, Menu::getModuleId,menuModelVo.getModuleId());
        // parent id 查询
        queryWrapper.eq(menuModelVo.getParentId() != null, Menu::getParentId, menuModelVo.getParentId());

        queryWrapper.orderByAsc(Menu::getSorting);

        List<Menu> menus = getBaseMapper().selectList(queryWrapper);
        List<MenuModelDto> menuModelDtoList = new ArrayList<>();

        if (menus.isEmpty()) {
            return new Result<>(Result.FAILURE, "暂无数据", menuModelDtoList);
        }

        for (Menu moduleMenu : menus) {
            MenuModelDto menuModelDto = new MenuModelDto();
            BeanUtils.copyProperties(moduleMenu, menuModelDto);
            menuModelDtoList.add(menuModelDto);
        }
        return new Result<>(Result.SUCCESS, menuModelDtoList);
    }
}
