// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:58
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.userrole;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.UserRoleMapper;
import os.api.v2.model.impl.user.pojo.UserRole;
import os.api.v2.model.service.user.dto.userrole.UserRoleModelDto;
import os.api.v2.model.service.user.service.userrole.IUserRoleService;
import os.api.v2.model.service.user.vo.userrole.UserRoleModelVo;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * os.api.v2.model.impl.user.service.userrole.UserRoleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:58
 */
@DubboService(version = "2.0.0")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
    @Override
    public Result<List<Long>> getMultiModuleIdByUserId(Long userId) {
        List<Long> list = getBaseMapper().getMultiModuleIdByUserId(userId);
        if (list.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        return new Result<>(Result.SUCCESS, list);
    }

    @Override
    public Result<UserRoleModelDto> getRoleId(UserRoleModelVo userRoleModelVo) {
        String[] fieldArray = {"role_id"};
        LambdaQueryWrapper<UserRole> queryWrapper = new FieldValuesUtils<>(UserRole.class, fieldArray).queryWrapper();
        UserRole userRole = getBaseMapper().selectOne(queryWrapper);
        if (userRole == null) {
            return new Result<>(Result.FAILURE, null);
        }
        UserRoleModelDto userRoleModelDto = new UserRoleModelDto();
        BeanUtils.copyProperties(userRole, userRoleModelDto);
        return new Result<>(Result.SUCCESS, userRoleModelDto);
    }
}
