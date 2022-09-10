// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 00:18
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
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleStoreService;
import os.api.v2.model.service.user.vo.rolemodule.StoreModelVo;

/**
 * os.api.v2.model.impl.user.service.rolemodule.RoleModuleStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 00:18
 */
@DubboService(version = "2.0.0")
public class RoleModuleStoreServiceImpl extends ServiceImpl<RoleModuleMapper, RoleModule> implements IRoleModuleStoreService {
    @Override
    public Result<String> store(StoreModelVo storeModelVo) {
        if (exist(storeModelVo)) {
            return new Result<>(Result.FAILURE, "角色模块已经存在");
        }
        RoleModule entity = new RoleModule();
        BeanUtils.copyProperties(storeModelVo, entity);
        int i = getBaseMapper().insert(entity);
        if (i > 0) {
            return new Result<>(Result.SUCCESS, "创建成功");
        }
        return new Result<>(Result.FAILURE, "创建失败");
    }

    private boolean exist(StoreModelVo storeModelVo) {
        RoleModule result = getBaseMapper().selectOne(queryWrapper(storeModelVo));
        return result != null;
    }

    private LambdaQueryWrapper<RoleModule> queryWrapper(StoreModelVo storeModelVo) {
        String[] fieldArray = new String[]{
                "id",
                "role_id",
                "system_module_id"
        };
        LambdaQueryWrapper<RoleModule> queryWrapper = new FieldValuesUtils<>(RoleModule.class, fieldArray).queryWrapper();
        queryWrapper.eq(storeModelVo.getRoleId() != null, RoleModule::getRoleId, storeModelVo.getRoleId());
        queryWrapper.eq(storeModelVo.getSystemModuleId() != null, RoleModule::getSystemModuleId, storeModelVo.getSystemModuleId());
        return queryWrapper;
    }
}
