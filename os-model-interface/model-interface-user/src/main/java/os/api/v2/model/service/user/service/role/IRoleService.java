// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:38
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.role;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.vo.role.RoleModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.role.IRole
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:38
 */
public interface IRoleService {
    Result<List<RoleModelDto>> getRoleList(RoleModelVo roleModelVo);
}
