// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 22:02
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate;

import os.api.v2.api.system.dto.operate.IndexDto;
import os.api.v2.api.system.vo.operate.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import java.util.List;

/**
 * os.api.v2.api.system.service.operate.IOperateIndexService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 22:02
 */
public interface IOperateIndexService {
    Result<List<IndexDto>> index(IndexVo indexVo) throws UserException;
}
