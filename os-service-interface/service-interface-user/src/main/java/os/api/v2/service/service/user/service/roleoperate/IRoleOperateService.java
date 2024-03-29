// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:51
// +----------------------------------------------------------------------
package os.api.v2.service.service.user.service.roleoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.user.vo.roleoperate.RoleOperateServiceVo;

import java.util.List;

/**
 * os.api.v2.service.service.user.service.roleoperate.IRoleOperateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:51
 */
public interface IRoleOperateService {
    Result<List<Long>> getSystemMenuOperateIdList(RoleOperateServiceVo roleOperateServiceVo);
}
