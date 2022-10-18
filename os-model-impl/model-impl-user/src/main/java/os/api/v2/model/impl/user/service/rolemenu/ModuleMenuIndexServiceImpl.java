// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:37
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemenu;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.ModuleMenuMapper;
import os.api.v2.model.impl.user.pojo.ModuleMenu;
import os.api.v2.model.service.user.dto.modulemenu.IndexModelDto;
import os.api.v2.model.service.user.dto.modulemenu.IndexDataModelDto;
import os.api.v2.model.service.user.service.rolemenu.IModuleMenuIndexService;
import os.api.v2.model.service.user.vo.rolemenu.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.rolemenu.ModuleMenuIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:37
 */
@DubboService(version = "2.0.0")
public class ModuleMenuIndexServiceImpl extends ServiceImpl<ModuleMenuMapper, ModuleMenu> implements IModuleMenuIndexService {
    @Override
    public Result<IndexModelDto> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<ModuleMenu> queryWrapper = queryWrapper(indexModelVo);
        Page<ModuleMenu> page = new Page<>();
        Page<ModuleMenu> modulePage = getBaseMapper().selectPage(page, queryWrapper);
        IndexModelDto indexModelDto = new IndexModelDto();
        indexModelDto.setTotal(modulePage.getTotal());

        if (indexModelDto.getTotal() == 0) {
            return new Result<>(Result.SUCCESS, indexModelDto);
        }

        List<IndexDataModelDto> indexDataModelDtoList = new ArrayList<>();
        List<ModuleMenu> roleModuleList = modulePage.getRecords();
        for (ModuleMenu moduleMenu : roleModuleList) {
            IndexDataModelDto indexDataModelDto = new IndexDataModelDto();
            BeanUtils.copyProperties(moduleMenu, indexDataModelDto);
            indexDataModelDtoList.add(indexDataModelDto);
        }
        indexModelDto.setData(indexDataModelDtoList);
        return new Result<>(Result.SUCCESS, indexModelDto);
    }

    private LambdaQueryWrapper<ModuleMenu> queryWrapper(IndexModelVo indexModelVo) {
        String[] fieldArray = new String[]{
                "id",
                "role_id",
                "system_module_id",
                "system_menu_id"
        };
        LambdaQueryWrapper<ModuleMenu> queryWrapper = new FieldValuesUtils<>(ModuleMenu.class, fieldArray).queryWrapper();
        queryWrapper.eq(indexModelVo.getRoleId() != null, ModuleMenu::getRoleId, indexModelVo.getRoleId());
        queryWrapper.eq(indexModelVo.getSystemModuleId() != null, ModuleMenu::getSystemModuleId, indexModelVo.getSystemModuleId());
        return queryWrapper;
    }
}
