// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-09 00:00
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user;

import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.user.service.user.IUserOptionsService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-09 00:00
 */
public interface IUserOptionsService {
    Result<Map<String, Object>> options();
}
