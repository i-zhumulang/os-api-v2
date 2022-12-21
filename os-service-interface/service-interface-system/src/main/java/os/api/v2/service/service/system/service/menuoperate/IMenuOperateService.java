// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-12-21 22:59
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.service.menuoperate;

import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.dto.menuoperate.MenuOperateServiceDto;
import os.api.v2.service.service.system.vo.menuoperate.MenuOperateServiceVo;

import java.util.List;

/**
 * os.api.v2.service.service.system.service.menuoperate.IMenuOperateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-12-21 22:59
 */
public interface IMenuOperateService {
    Result<List<MenuOperateServiceDto>> getMenuOperateList(MenuOperateServiceVo menuOperateServiceVo);
}
