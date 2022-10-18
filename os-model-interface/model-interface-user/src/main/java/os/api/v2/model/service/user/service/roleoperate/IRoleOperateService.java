// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:27
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.roleoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.roleoperate.RoleOperateModelDto;
import os.api.v2.model.service.user.vo.roleoperate.RoleOperateModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.roleperate.IRoleOperateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:27
 */
public interface IRoleOperateService {
    Result<List<RoleOperateModelDto>> systemMenuOperateList(RoleOperateModelVo roleOperateModelVo, String[] fieldArray);
}
