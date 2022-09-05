// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 23:16
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
import os.api.v2.model.service.system.service.menuoperate.IGetListByIdListService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * os.api.v2.model.impl.system.service.menuoperate.GetListByIdListServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 23:16
 */
@DubboService(version = "2.0.0")
public class IGetListByIdListServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IGetListByIdListService {
    @Override
    public Result<List<MenuOperateModelDto>> getListByIdList(List<Long> idList, String[] fieldArray) {
        LambdaQueryWrapper<MenuOperate> queryWrapper = new FieldValuesUtils<>(MenuOperate.class, fieldArray).queryWrapper();
        queryWrapper.in(MenuOperate::getId, idList);
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
