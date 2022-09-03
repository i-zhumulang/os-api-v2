// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 21:07
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate;

import os.api.v2.api.system.dto.operate.CreateDto;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.operate.IOperateCreateService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 21:07
 */
public interface IOperateCreateService {
    Result<CreateDto> create();
}
