// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:05
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.auth;

import os.api.v2.api.user.dto.auth.LoginDto;
import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.user.service.auth.ILoginService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:05
 */
public interface ILoginService {
    Result<Map<String, Object>> login(LoginDto loginDto);
}