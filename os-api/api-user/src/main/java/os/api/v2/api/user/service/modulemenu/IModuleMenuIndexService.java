// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:56
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.modulemenu;

import os.api.v2.api.user.dto.modulemenu.IndexDto;
import os.api.v2.api.user.vo.modulemenu.IndexVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.modulemenu.IModuleMenuIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:56
 */
public interface IModuleMenuIndexService {
    Result<IndexDto> index(IndexVo indexVo);
}
