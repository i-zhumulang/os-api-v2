// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 20:32
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.rolemodule;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;
import os.api.v2.model.service.user.vo.rolemodule.UpdateModelVo;

/**
 * os.api.v2.model.service.user.service.rolemodule.IRoleModuleUpdateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 20:32
 */
public interface IRoleModuleUpdateService {
    Result<RoleModuleModelDto> update(UpdateModelVo updateModelVo);
}
