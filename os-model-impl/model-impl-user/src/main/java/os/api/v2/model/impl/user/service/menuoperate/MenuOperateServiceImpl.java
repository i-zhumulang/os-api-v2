// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:28
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.menuoperate;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.MenuOperateMapper;
import os.api.v2.model.impl.user.pojo.MenuOperate;
import os.api.v2.model.impl.user.pojo.ModuleMenu;
import os.api.v2.model.service.user.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.model.service.user.vo.menuoperate.MenuOperateModelVo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * os.api.v2.model.impl.user.service.menuoperate.MenuOperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:28
 */
@DubboService(version = "2.0.0")
public class MenuOperateServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IMenuOperateService {
    @Override
    public Result<List<MenuOperateModelDto>> systemMenuOperateList(MenuOperateModelVo menuOperateModelVo, String[] fieldArray) {
        LambdaQueryWrapper<MenuOperate> queryWrapper = new FieldValuesUtils<>(MenuOperate.class, fieldArray).queryWrapper();

        queryWrapper.eq(
                menuOperateModelVo.getModuleMenuId() != null,
                MenuOperate::getModuleMenuId,
                menuOperateModelVo.getModuleMenuId()
        );
        queryWrapper.eq(
                menuOperateModelVo.getRoleId() != null,
                MenuOperate::getRoleId,
                menuOperateModelVo.getRoleId()
        );
        queryWrapper.eq(
                menuOperateModelVo.getSystemModuleId() != null,
                MenuOperate::getSystemModuleId,
                menuOperateModelVo.getSystemModuleId()
        );
        queryWrapper.eq(
                menuOperateModelVo.getSystemMenuId() != null,
                MenuOperate::getSystemMenuId,
                menuOperateModelVo.getSystemMenuId()
        );
        List<MenuOperate> menuOperates = getBaseMapper().selectList(queryWrapper);
        if (menuOperates.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }

        List<MenuOperateModelDto> menuOperateModelDtoList = new ArrayList<>();
        for (MenuOperate menuOperate : menuOperates) {
            MenuOperateModelDto menuOperateModelDto = new MenuOperateModelDto();
            BeanUtils.copyProperties(menuOperate, menuOperateModelDto);
            menuOperateModelDtoList.add(menuOperateModelDto);
        }
        return new Result<>(Result.SUCCESS, menuOperateModelDtoList);
    }
}
