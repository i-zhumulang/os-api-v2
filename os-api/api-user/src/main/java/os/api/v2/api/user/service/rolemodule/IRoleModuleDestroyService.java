// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 10:11
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.vo.rolemodule.DestroyVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleDestroyService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 10:11
 */
public interface IRoleModuleDestroyService {
    Result<String> destroy(DestroyVo destroyVo);
}
