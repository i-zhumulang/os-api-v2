// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:33
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.useraccount;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.UserAccountMapper;
import os.api.v2.model.impl.user.pojo.UserAccount;
import os.api.v2.model.service.user.dto.useraccount.UserAccountDto;
import os.api.v2.model.service.user.service.useraccount.IUserAccountService;

/**
 * os.api.v2.model.impl.user.service.useraccount.UserAccountServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:33
 */
@DubboService(version = "2.0.0")
public class UserAccountServiceImpl extends ServiceImpl<UserAccountMapper, UserAccount> implements IUserAccountService {
    @Override
    public Result<UserAccountDto> getSingle(UserAccountDto userAccountDto, String[] fieldArray) {
        LambdaQueryWrapper<UserAccount> queryWrapper = new FieldValuesUtils<>(UserAccount.class, fieldArray).queryWrapper();

        queryWrapper.eq(userAccountDto.getUserId() != null, UserAccount::getUserId, userAccountDto.getUserId());
        queryWrapper.eq(userAccountDto.getMobile() != null, UserAccount::getMobile, userAccountDto.getMobile());

        UserAccount userAccount = getBaseMapper().selectOne(queryWrapper);
        if (userAccount == null) {
            return new Result<>(Result.FAILURE, "账号不存在", null);
        }
        UserAccountDto userAccountDto1 = new UserAccountDto();
        BeanUtils.copyProperties(userAccount, userAccountDto1);
        return new Result<>(Result.SUCCESS, userAccountDto1);
    }
}
