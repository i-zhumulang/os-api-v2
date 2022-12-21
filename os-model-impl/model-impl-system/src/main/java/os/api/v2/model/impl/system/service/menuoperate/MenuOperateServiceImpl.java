// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 21:27
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
import os.api.v2.model.service.system.service.menuoperate.IMenuOperateService;
import os.api.v2.model.service.system.vo.menuoperate.MenuOperateModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.system.service.menuoperate.OperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 21:27
 */
@DubboService(version = "2.0.0")
public class MenuOperateServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IMenuOperateService {
    @Override
    public Result<String> destroy(MenuOperateModelDto menuOperateModelDto) {
        int result = getBaseMapper().deleteById(menuOperateModelDto.getId());
        if (result > 0) {
            return new Result<>(Result.SUCCESS, "删除成功");
        }
        return new Result<>(Result.FAILURE, "删除失败");
    }

    @Override
    public Result<List<MenuOperateModelDto>> getMenuOperateList(MenuOperateModelVo modelVo) {
        LambdaQueryWrapper<MenuOperate> queryWrapper = new FieldValuesUtils<>(MenuOperate.class, modelVo.getFieldArray()).queryWrapper();
        // id 查询
        queryWrapper.eq(modelVo.getId() != null, MenuOperate::getId, modelVo.getId());
        // menu id查询
        queryWrapper.eq(modelVo.getMenuId() != null, MenuOperate::getMenuId, modelVo.getMenuId());
        // module id查询
        queryWrapper.eq(modelVo.getModuleId() != null, MenuOperate::getModuleId, modelVo.getModuleId());

        List<MenuOperate> menuOperateList = getBaseMapper().selectList(queryWrapper);
        List<MenuOperateModelDto> menuOperateModelDtoList = new ArrayList<>();

        if (menuOperateList.isEmpty()) {
            return new Result<>(Result.FAILURE, "暂无数据", menuOperateModelDtoList);
        }

        for (MenuOperate menuOperate : menuOperateList) {
            MenuOperateModelDto menuOperateModelDto = new MenuOperateModelDto();
            BeanUtils.copyProperties(menuOperate, menuOperateModelDto);
            menuOperateModelDtoList.add(menuOperateModelDto);
        }

        return new Result<>(Result.SUCCESS, menuOperateModelDtoList);
    }
}
