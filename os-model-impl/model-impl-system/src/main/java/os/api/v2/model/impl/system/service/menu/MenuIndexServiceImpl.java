// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 11:07
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
import os.api.v2.model.service.system.service.menu.IMenuIndexService;
import os.api.v2.model.service.system.vo.menu.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.menu.MenuIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 11:07
 */
@DubboService(version = "2.0.0")
public class MenuIndexServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuIndexService {
    @Override
    public Result<List<MenuModelDto>> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<Menu> queryWrapper = new FieldValuesUtils<>(Menu.class, indexModelVo.getFieldArray()).queryWrapper();
        queryWrapper.eq(indexModelVo.getModuleId() != null, Menu::getModuleId, indexModelVo.getModuleId());
        queryWrapper.orderByAsc(Menu::getSorting);
        List<Menu> menus = getBaseMapper().selectList(queryWrapper);
        if (menus.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<MenuModelDto> menuModelDtoList = new ArrayList<>();
        for (Menu menu: menus) {
            MenuModelDto menuModelDto = new MenuModelDto();
            BeanUtils.copyProperties(menu, menuModelDto);
            menuModelDtoList.add(menuModelDto);
        }
        return new Result<>(Result.SUCCESS, menuModelDtoList);
    }
}
