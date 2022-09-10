// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 23:01
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.dto.rolemodule.CreateDto;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleCreateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 23:01
 */
public interface IRoleModuleCreateService {
    Result<CreateDto> create();
}
