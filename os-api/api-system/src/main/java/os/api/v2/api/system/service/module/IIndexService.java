// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 17:59
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module;

import os.api.v2.api.system.dto.module.IndexDto;
import os.api.v2.api.system.vo.module.IndexVo;
import os.api.v2.common.base.common.Result;

import java.util.List;

/**
 * os.api.v2.api.system.service.module.IIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 17:59
 */
public interface IIndexService {
    Result<List<IndexDto>> index(IndexVo indexVo);
}
