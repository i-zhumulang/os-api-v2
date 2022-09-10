// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:40
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.role;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.RoleMapper;
import os.api.v2.model.impl.user.pojo.Role;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.service.role.IRoleService;
import os.api.v2.model.service.user.vo.role.RoleModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.role.IRoleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:40
 */
@DubboService(version = "2.0.0")
public class IRoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {
    @Override
    public Result<List<RoleModelDto>> getRoleList(RoleModelVo roleModelVo) {
        LambdaQueryWrapper<Role> queryWrapper = new FieldValuesUtils<>(Role.class, roleModelVo.getFieldArray()).queryWrapper();
        List<Role> roles = getBaseMapper().selectList(queryWrapper);
        if (roles.isEmpty()) {
            return new Result<>(Result.FAILURE, "数据不存在");
        }
        List<RoleModelDto> roleModelDtoList = new ArrayList<>();
        for (Role role : roles) {
            RoleModelDto roleModelDto = new RoleModelDto();
            BeanUtils.copyProperties(role, roleModelDto);
            roleModelDtoList.add(roleModelDto);
        }
        return new Result<>(Result.SUCCESS, roleModelDtoList);
    }
}
