// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:45
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user;

import os.api.v2.api.user.vo.user.RegisterVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.service.user.IRegisterService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:45
 */
public interface IRegisterService {
    Result<Integer> register(RegisterVo registerVo);
}
