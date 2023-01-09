// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2023-01-09 22:18
// +----------------------------------------------------------------------
package os.api.v2.service.service.user.service.roleoperate;

import os.api.v2.common.base.common.Result;

import java.util.List;

/**
 * os.api.v2.service.service.user.service.roleoperate.IPermissionCreateSystemOperateIdService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2023-01-09 22:18
 */
public interface IPermissionCreateSystemOperateIdService {
    Result<List<Long>> permissionCreateSystemOperateId(Long roleModuleId);
}
