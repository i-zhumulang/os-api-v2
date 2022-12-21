// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 22:11
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menuoperate;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.system.mapper.MenuOperateMapper;
import os.api.v2.model.impl.system.pojo.MenuOperate;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IMenuOperateIndexService;
import os.api.v2.model.service.system.vo.menuoperate.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.menuoperate.OperateIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 22:11
 */
@DubboService(version = "2.0.0")
public class MenuOperateIndexServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IMenuOperateIndexService {
    @Override
    public Result<List<MenuOperateModelDto>> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<MenuOperate> queryWrapper = new FieldValuesUtils<>(MenuOperate.class, indexModelVo.getFieldArray()).queryWrapper();
        queryWrapper.eq(indexModelVo.getModuleId() != null, MenuOperate::getModuleId, indexModelVo.getModuleId());
        queryWrapper.eq(indexModelVo.getMenuId() != null, MenuOperate::getMenuId, indexModelVo.getMenuId());
        queryWrapper.eq(indexModelVo.getLocation() != null, MenuOperate::getLocation, indexModelVo.getLocation());
        queryWrapper.orderByAsc(MenuOperate::getSorting);
        List<MenuOperate> menuOperates = getBaseMapper().selectList(queryWrapper);
        if (menuOperates.isEmpty()) {
            return new Result<>(Result.FAILURE, "暂无数据", null);
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
