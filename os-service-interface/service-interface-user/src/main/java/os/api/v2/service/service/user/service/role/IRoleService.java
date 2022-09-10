// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 13:06
// +----------------------------------------------------------------------
package os.api.v2.service.service.user.service.role;

import os.api.v2.common.base.common.Result;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.service.service.user.service.role.IRoleService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 13:06
 */
public interface IRoleService {
    Result<Map<Integer, String>> getRoleIdNameZhMap();
}
