// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-12 22:44
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.vo.rolemodule.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-12 22:44
 */
public interface IRoleModuleUpdateService {
    Result<RoleModuleModelDto> update(UpdateVo updateVo);
}
