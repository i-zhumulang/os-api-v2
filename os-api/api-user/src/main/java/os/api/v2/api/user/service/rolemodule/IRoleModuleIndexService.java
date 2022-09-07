// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:24
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule;

import os.api.v2.api.user.dto.rolemodule.IndexDto;
import os.api.v2.api.user.vo.rolemodule.IndexVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.rolemodule.IRoleModuleIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:24
 */
public interface IRoleModuleIndexService {
    Result<IndexDto> index(IndexVo indexVo);
}
