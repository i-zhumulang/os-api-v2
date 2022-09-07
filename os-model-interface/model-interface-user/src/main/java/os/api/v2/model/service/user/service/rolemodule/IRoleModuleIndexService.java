// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:09
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.rolemodule;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemodule.IndexModelDto;
import os.api.v2.model.service.user.vo.rolemodule.IndexModelVo;

/**
 * os.api.v2.model.service.user.service.rolemodule.IRoleModuleIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:09
 */
public interface IRoleModuleIndexService {
    Result<IndexModelDto> index(IndexModelVo indexModelVo);
}
