// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 21:00
// +----------------------------------------------------------------------
package os.api.v2.api.user.realm;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.authc.*;
import org.springframework.stereotype.Component;
import os.api.v2.common.auth.realm.Profile;
import os.api.v2.common.auth.realm.ShiroRealm;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.common.base.utils.PasswordAesUtils;
import os.api.v2.common.base.utils.PasswordRsaUtils;
import os.api.v2.common.base.utils.aes.AesResult;
import os.api.v2.model.service.user.dto.useraccount.UserAccountDto;
import os.api.v2.model.service.user.service.useraccount.IUserAccountService;

import java.util.Objects;

/**
 * os.api.v2.api.user.realm
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 21:00
 */
@Slf4j
public class AuthRealm extends ShiroRealm {
    @DubboReference(version = "2.0.0")
    protected IUserAccountService iUserAccountService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        // 获取用户手机号码和密码
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        log.info(token.toString());
        String mobile = token.getUsername();
        log.info(mobile);
        // 获取解密密码
        String password = PasswordRsaUtils.decode(String.valueOf(token.getPassword()));
        log.info(password);
        UserAccountDto account = null;
        try {
            // 根据手机号码查询用户
            account = this.getUserAccountDto(mobile);
        } catch (UserException e) {
            return null;
        }
        // 判断用户是否存在，密码是否一致
        AesResult aesResult = PasswordAesUtils.decode(
                account.getAuthentication(),
                account.getSalt(),
                account.getIv()
        );
        if (aesResult.getResult().equals(password)) {
            Profile profile = new Profile();
            profile.setId(account.getUserId());
            profile.setMobile(account.getMobile());
            // 密码验证通过
            return new SimpleAuthenticationInfo(
                    profile,
                    token.getPassword(),
                    this.getName()
            );
        }
        log.info("66666");
        // 构造安全数据并返回
        return null;
    }

    /**
     * 根据手机号码获取登录信息
     *
     * @param mobile
     * @return UserAccountDto
     * @author 吴荣超
     * @date 10:13 2022/8/14
     */
    private UserAccountDto getUserAccountDto(String mobile) throws UserException {
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setMobile(mobile);
        String[] fieldArray = {
                "user_id",
                "mobile",
                "authentication",
                "salt",
                "iv",
                "state",
                "deleted_state"
        };
        Result<UserAccountDto> single = iUserAccountService.getSingle(userAccountDto, fieldArray);
        if (Objects.equals(single.getFlag(), Result.FAILURE)) {
            throw new UserException(single.getMessage());
        }
        return single.getData();
    }
}
