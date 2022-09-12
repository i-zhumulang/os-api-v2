// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 20:33
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemodule;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.user.mapper.RoleModuleMapper;
import os.api.v2.model.impl.user.pojo.RoleModule;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleUpdateService;
import os.api.v2.model.service.user.vo.rolemodule.UpdateModelVo;

/**
 * os.api.v2.model.impl.user.service.rolemodule.RoleModuleUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 20:33
 */
@DubboService(version = "2.0.0")
public class RoleModuleUpdateServiceImpl extends ServiceImpl<RoleModuleMapper, RoleModule> implements IRoleModuleUpdateService {
    @Override
    public Result<RoleModuleModelDto> update(UpdateModelVo updateModelVo) {
        // 存在菜单,无法编辑
        LambdaQueryWrapper<RoleModule> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(RoleModule::getId, updateModelVo.getId());
        RoleModule canUpdate = getBaseMapper().selectOne(queryWrapper);
        if (canUpdate.getCount() > 0) {
            return new Result<>(Result.FAILURE, "存在菜单,无法删除");
        }
        // 不存在、进行编辑操作
        RoleModule entity = new RoleModule();
        BeanUtils.copyProperties(updateModelVo, entity);
        int i = getBaseMapper().updateById(entity);
        if (i == 0) {
            return new Result<>(Result.FAILURE, "更新失败");
        }
        RoleModule roleModule = getBaseMapper().selectById(updateModelVo.getId());
        RoleModuleModelDto roleModuleModelDto = new RoleModuleModelDto();
        BeanUtils.copyProperties(roleModule, roleModuleModelDto);
        return new Result<>(Result.SUCCESS, "更新成功", roleModuleModelDto);
    }
}
