// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:36
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.rolemenu;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.rolemenu.IndexModelDto;
import os.api.v2.model.service.user.vo.rolemenu.IndexModelVo;

/**
 * os.api.v2.model.service.user.service.rolemenu.IRoleMenuIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:36
 */
public interface IRoleMenuIndexService {
    Result<IndexModelDto> index(IndexModelVo indexModelVo);
}
