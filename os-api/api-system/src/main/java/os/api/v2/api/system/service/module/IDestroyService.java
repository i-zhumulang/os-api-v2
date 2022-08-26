// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-26 22:20
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module;

import os.api.v2.api.system.vo.module.ModuleVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.system.service.module.IDestroyService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-26 22:20
 */
public interface IDestroyService {
    Result<String> destroy(ModuleVo moduleVo);
}
