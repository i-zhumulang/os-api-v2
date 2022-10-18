// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:38
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.rolemenu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.vo.rolemenu.ModuleMenuModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.user.service.rolemenu.IModuleMenuService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:38
 */
public interface IModuleMenuService {
    Result<List<Long>> permission(ModuleMenuModelVo moduleMenuModelVo);
}
