// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-12 22:48
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModuleUpdateService;
import os.api.v2.api.user.vo.rolemodule.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.vo.rolemodule.UpdateModelVo;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-12 22:48
 */
@Service
public class RoleModuleUpdateServiceImpl implements IRoleModuleUpdateService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.rolemodule.IRoleModuleUpdateService iRoleModuleUpdateService;

    @Override
    public Result<RoleModuleModelDto> update(UpdateVo updateVo) {
        UpdateModelVo updateModelVo = new UpdateModelVo();
        BeanUtils.copyProperties(updateVo, updateModelVo);
        return iRoleModuleUpdateService.update(updateModelVo);
    }
}
