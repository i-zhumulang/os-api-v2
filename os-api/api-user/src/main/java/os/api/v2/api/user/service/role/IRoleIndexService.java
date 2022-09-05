// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:21
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.role;

import os.api.v2.api.user.dto.role.IndexDto;
import os.api.v2.common.base.common.Result;

import java.util.List;

/**
 * os.api.v2.api.user.service.role.IRoleIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:21
 */
public interface IRoleIndexService {
    Result<List<IndexDto>> index();
}
