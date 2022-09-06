// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:13
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user;

import os.api.v2.api.user.dto.user.IndexDto;
import os.api.v2.api.user.vo.user.IndexVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.user.IUserIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:13
 */
public interface IUserIndexService {
    Result<IndexDto> index(IndexVo indexVo);
}
