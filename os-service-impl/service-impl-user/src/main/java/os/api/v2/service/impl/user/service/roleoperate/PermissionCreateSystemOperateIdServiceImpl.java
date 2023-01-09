// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-09 22:20
// +----------------------------------------------------------------------
package os.api.v2.service.impl.user.service.roleoperate;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.roleoperate.RoleOperateModelDto;
import os.api.v2.model.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.model.service.user.vo.roleoperate.RoleOperateModelVo;
import os.api.v2.service.service.user.service.roleoperate.IPermissionCreateSystemOperateIdService;

import java.util.List;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.user.service.roleoperate.PermissionCreateSystemOperateIdServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-09 22:20
 */
@DubboService(version = "2.0.0")
public class PermissionCreateSystemOperateIdServiceImpl implements IPermissionCreateSystemOperateIdService {
    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @Override
    public Result<List<Long>> permissionCreateSystemOperateId(Long roleModuleId) {
        RoleOperateModelVo modelVo = new RoleOperateModelVo();
        modelVo.setRoleModuleId(roleModuleId);

        String[] fieldArray = new String[]{
                "system_menu_operate_id"
        };

        Result<List<RoleOperateModelDto>> result = iRoleOperateService.systemMenuOperateList(modelVo, fieldArray);
        List<Long> list = result.getData()
                .stream()
                .map(RoleOperateModelDto::getSystemMenuOperateId)
                .collect(Collectors.toList());
        return new Result<>(Result.SUCCESS, list);
    }
}
