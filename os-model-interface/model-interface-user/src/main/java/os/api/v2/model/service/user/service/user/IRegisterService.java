// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:49
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.user;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.vo.user.RegisterModelVo;

/**
 * os.api.v2.model.service.user.service.user.IRegisterService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:49
 */
public interface IRegisterService {
    Result<Integer> register(RegisterModelVo registerModelVo);
}
