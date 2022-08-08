// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 22:47
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemodule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.RoleModuleMapper;
import os.api.v2.model.impl.user.pojo.RoleModule;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;
import os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo;

/**
 * os.api.v2.model.impl.user.service.rolemodule.RoleModuleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 22:47
 */
@DubboService(version = "2.0.0")
public class RoleModuleServiceImpl extends ServiceImpl<RoleModuleMapper, RoleModule> implements IRoleModuleService {
    @Override
    public Result<RoleModuleModelDto> getSingle(RoleModuleModelVo roleModuleModelVo) {
        String[] fieldArray = {"module_menu_id"};
        LambdaQueryWrapper<RoleModule> queryWrapper = new FieldValuesUtils<>(RoleModule.class, fieldArray).queryWrapper();
        queryWrapper.eq(RoleModule::getRoleId, roleModuleModelVo.getRoleId());
        queryWrapper.eq(RoleModule::getSystemModuleId, roleModuleModelVo.getSystemModuleId());
        RoleModule roleModule = getBaseMapper().selectOne(queryWrapper);
        if (roleModule == null) {
            return new Result<>(Result.FAILURE, null);
        }
        RoleModuleModelDto roleModuleModelDto = new RoleModuleModelDto();
        BeanUtils.copyProperties(roleModule, roleModuleModelDto);
        return new Result<>(Result.SUCCESS, roleModuleModelDto);
    }
}
