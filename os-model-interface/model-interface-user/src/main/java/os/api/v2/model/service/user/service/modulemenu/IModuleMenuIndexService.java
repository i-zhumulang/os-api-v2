// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:36
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.modulemenu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.modulemenu.IndexModelDto;
import os.api.v2.model.service.user.vo.modulemenu.IndexModelVo;

/**
 * os.api.v2.model.service.user.service.modulemenu.IModuleMenuIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:36
 */
public interface IModuleMenuIndexService {
    Result<IndexModelDto> index(IndexModelVo indexModelVo);
}
