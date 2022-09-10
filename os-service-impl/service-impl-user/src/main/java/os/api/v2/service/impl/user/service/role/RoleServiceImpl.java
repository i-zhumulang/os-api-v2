// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 13:07
// +----------------------------------------------------------------------
package os.api.v2.service.impl.user.service.role;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.vo.role.RoleModelVo;
import os.api.v2.service.service.user.service.role.IRoleService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.user.service.role.RoleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 13:07
 */
@DubboService(version = "2.0.0")
public class RoleServiceImpl implements IRoleService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.role.IRoleService iRoleService;

    @Override
    public Result<Map<Integer, String>> getRoleIdNameZhMap() {
        RoleModelVo roleModelVo = new RoleModelVo();
        roleModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<RoleModelDto>> result = iRoleService.getRoleList(roleModelVo);
        Map<Integer, String> idName = result.getData()
                .stream()
                .collect(
                        Collectors.toMap(
                                RoleModelDto::getId,
                                RoleModelDto::getNameZh
                        )
                );
        return new Result<>(Result.SUCCESS, idName);
    }
}
