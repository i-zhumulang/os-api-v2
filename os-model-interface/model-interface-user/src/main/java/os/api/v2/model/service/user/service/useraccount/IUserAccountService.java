// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:29
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.service.useraccount;

import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.useraccount.UserAccountDto;

/**
 * os.api.v2.model.service.user.service.useraccount.IUserAccountService
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:29
 */
public interface IUserAccountService {
    Result<UserAccountDto> getSingle(UserAccountDto userAccountDto, String[] fieldArray);
}
