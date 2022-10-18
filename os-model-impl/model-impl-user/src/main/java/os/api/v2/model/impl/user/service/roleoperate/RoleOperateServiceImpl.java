// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:28
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.roleoperate;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.MenuOperateMapper;
import os.api.v2.model.impl.user.pojo.RoleOperate;
import os.api.v2.model.service.user.dto.roleoperate.RoleOperateModelDto;
import os.api.v2.model.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.model.service.user.vo.roleoperate.RoleOperateModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.roleoperate.MenuOperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:28
 */
@DubboService(version = "2.0.0")
public class RoleOperateServiceImpl extends ServiceImpl<MenuOperateMapper, RoleOperate> implements IRoleOperateService {
    @Override
    public Result<List<RoleOperateModelDto>> systemMenuOperateList(RoleOperateModelVo roleOperateModelVo, String[] fieldArray) {
        LambdaQueryWrapper<RoleOperate> queryWrapper = new FieldValuesUtils<>(RoleOperate.class, fieldArray).queryWrapper();

        queryWrapper.eq(
                roleOperateModelVo.getModuleMenuId() != null,
                RoleOperate::getModuleMenuId,
                roleOperateModelVo.getModuleMenuId()
        );
        queryWrapper.eq(
                roleOperateModelVo.getRoleId() != null,
                RoleOperate::getRoleId,
                roleOperateModelVo.getRoleId()
        );
        queryWrapper.eq(
                roleOperateModelVo.getSystemModuleId() != null,
                RoleOperate::getSystemModuleId,
                roleOperateModelVo.getSystemModuleId()
        );
        queryWrapper.eq(
                roleOperateModelVo.getSystemMenuId() != null,
                RoleOperate::getSystemMenuId,
                roleOperateModelVo.getSystemMenuId()
        );
        List<RoleOperate> roleOperates = getBaseMapper().selectList(queryWrapper);
        if (roleOperates.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }

        List<RoleOperateModelDto> roleOperateModelDtoList = new ArrayList<>();
        for (RoleOperate roleOperate : roleOperates) {
            RoleOperateModelDto roleOperateModelDto = new RoleOperateModelDto();
            BeanUtils.copyProperties(roleOperate, roleOperateModelDto);
            roleOperateModelDtoList.add(roleOperateModelDto);
        }
        return new Result<>(Result.SUCCESS, roleOperateModelDtoList);
    }
}
