// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 10:59
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.service.menu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.vo.menu.IndexModelVo;

import java.util.List;

/**
 * os.api.v2.model.service.system.service.menu.IIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 10:59
 */
public interface IMenuIndexService {
    Result<List<MenuModelDto>> index(IndexModelVo indexModelVo);
}
