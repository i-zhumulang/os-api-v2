// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:20
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.user;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.user.IndexModelDto;
import os.api.v2.model.service.user.vo.user.IndexModelVo;

/**
 * os.api.v2.model.service.user.service.user.IUserIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:20
 */
public interface IUserIndexService {
    Result<IndexModelDto> index(IndexModelVo indexModelVo);
}
