// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:58
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.userrole;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.userrole.UserRoleModelDto;
import os.api.v2.model.service.user.vo.userrole.UserRoleModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.userrole.IUserRoleService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:58
 */
public interface IUserRoleService {
    Result<List<Long>> getMultiModuleIdByUserId(Long userId);

    Result<UserRoleModelDto> getRoleId(UserRoleModelVo userRoleModelVo);
}
