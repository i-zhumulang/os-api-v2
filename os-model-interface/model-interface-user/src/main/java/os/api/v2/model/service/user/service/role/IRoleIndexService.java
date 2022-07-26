// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:14
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.role;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.role.RoleModelDto;
import os.api.v2.model.service.user.vo.role.IndexModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.role.IRoleIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:14
 */
public interface IRoleIndexService {
    Result<List<RoleModelDto>> index(IndexModelVo indexModelVo);
}
