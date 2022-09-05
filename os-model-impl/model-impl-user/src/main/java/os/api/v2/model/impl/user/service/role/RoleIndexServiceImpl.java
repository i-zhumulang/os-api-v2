// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:16
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
import os.api.v2.model.service.user.service.role.IRoleIndexService;
import os.api.v2.model.service.user.vo.role.IndexModelVo;

import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.role.RoleIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:16
 */
@DubboService(version = "2.0.0")
public class RoleIndexServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleIndexService {
    @Override
    public Result<List<RoleModelDto>> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<Role> queryWrapper = new FieldValuesUtils<>(Role.class, indexModelVo.getFieldArray()).queryWrapper();
        queryWrapper.orderByAsc(Role::getId);
        List<Role> modules = getBaseMapper().selectList(queryWrapper);
        if (modules.isEmpty()) {
            return new Result<>(Result.FAILURE, null);
        }
        List<RoleModelDto> roleModelDtoList = new ArrayList<>();
        for (Role module : modules) {
            RoleModelDto roleModelDto = new RoleModelDto();
            BeanUtils.copyProperties(module, roleModelDto);
            roleModelDtoList.add(roleModelDto);
        }
        return new Result<>(Result.SUCCESS, roleModelDtoList);
    }
}
