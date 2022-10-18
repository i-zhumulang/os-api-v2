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
import os.api.v2.model.impl.user.pojo.RoleMenu;
import os.api.v2.model.service.user.dto.rolemenu.IndexModelDto;
import os.api.v2.model.service.user.dto.rolemenu.IndexDataModelDto;
import os.api.v2.model.service.user.service.rolemenu.IRoleMenuIndexService;
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
public class RoleMenuIndexServiceImpl extends ServiceImpl<ModuleMenuMapper, RoleMenu> implements IRoleMenuIndexService {
    @Override
    public Result<IndexModelDto> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<RoleMenu> queryWrapper = queryWrapper(indexModelVo);
        Page<RoleMenu> page = new Page<>();
        Page<RoleMenu> modulePage = getBaseMapper().selectPage(page, queryWrapper);
        IndexModelDto indexModelDto = new IndexModelDto();
        indexModelDto.setTotal(modulePage.getTotal());

        if (indexModelDto.getTotal() == 0) {
            return new Result<>(Result.SUCCESS, indexModelDto);
        }

        List<IndexDataModelDto> indexDataModelDtoList = new ArrayList<>();
        List<RoleMenu> roleModuleList = modulePage.getRecords();
        for (RoleMenu roleMenu : roleModuleList) {
            IndexDataModelDto indexDataModelDto = new IndexDataModelDto();
            BeanUtils.copyProperties(roleMenu, indexDataModelDto);
            indexDataModelDtoList.add(indexDataModelDto);
        }
        indexModelDto.setData(indexDataModelDtoList);
        return new Result<>(Result.SUCCESS, indexModelDto);
    }

    private LambdaQueryWrapper<RoleMenu> queryWrapper(IndexModelVo indexModelVo) {
        String[] fieldArray = new String[]{
                "id",
                "role_id",
                "system_module_id",
                "system_menu_id"
        };
        LambdaQueryWrapper<RoleMenu> queryWrapper = new FieldValuesUtils<>(RoleMenu.class, fieldArray).queryWrapper();
        queryWrapper.eq(indexModelVo.getRoleId() != null, RoleMenu::getRoleId, indexModelVo.getRoleId());
        queryWrapper.eq(indexModelVo.getSystemModuleId() != null, RoleMenu::getSystemModuleId, indexModelVo.getSystemModuleId());
        return queryWrapper;
    }
}
