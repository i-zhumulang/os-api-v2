// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 10:19
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu;

import os.api.v2.api.system.dto.menu.IndexDto;
import os.api.v2.api.system.vo.menu.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import java.util.List;

/**
 * os.api.v2.api.system.service.menu.IIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 10:19
 */
public interface IMenuIndexService {
    Result<List<IndexDto>> index(IndexVo indexVo) throws UserException;
}
