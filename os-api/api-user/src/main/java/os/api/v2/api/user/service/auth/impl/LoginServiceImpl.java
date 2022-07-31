// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:06
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.auth.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.auth.LoginDto;
import os.api.v2.api.user.service.auth.ILoginService;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.common.base.utils.PasswordAesUtils;
import os.api.v2.common.base.utils.PasswordRsaUtils;
import os.api.v2.common.base.utils.aes.AesResult;
import os.api.v2.common.base.utils.jwt.JwtUtils;
import os.api.v2.model.service.user.dto.useraccount.UserAccountDto;
import os.api.v2.model.service.user.service.useraccount.IUserAccountService;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * os.api.v2.api.user.service.auth.impl.LoginServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:06
 */
@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Value("${custom.jwt.expire_time}")
    protected long expireTime;

    @DubboReference(version = "2.0.0")
    protected IUserAccountService iUserAccountService;

    /**
     * login
     *
     * @param loginDto 登录表单
     * @return Result<Map < String, Object>>
     * @author 吴荣超
     * @date 20:52 2022/7/26
     */
    @Override
    public Result<Map<String, Object>> login(LoginDto loginDto) throws UserException {

        UserAccountDto userAccountDto = this.getUserAccountDto(loginDto);
        // 解密输入密码
        String password = PasswordRsaUtils.decode(loginDto.getPassword());
        // 判断用户是否存在，密码是否一致
        AesResult aesResult = PasswordAesUtils.decode(
                userAccountDto.getAuthentication(),
                userAccountDto.getSalt(),
                userAccountDto.getIv()
        );
        // 判断密码是否一致
        if (!aesResult.getResult().equals(password)) {
            return new Result<>(Result.FAILURE, "账号或者密码有误");
        }
        // 根据用户ID生成Token
        String token = JwtUtils.sign(userAccountDto.getUserId());
        if (token == null) {
            return new Result<>(Result.FAILURE, "服务器异常，获取token失败");
        }
        redisTemplate.opsForValue().set(token, token, expireTime * 2 / 100, TimeUnit.SECONDS);

        // 构造返回结果
        Map<String, Object> map = new HashMap<>();
        map.put("token", token);

        return new Result<>(Result.SUCCESS, "登录成功", map);
    }

    /**
     * 根据手机号码获取数据
     *
     * @param loginDto 表单
     * @return UserAccountDto
     * @author 吴荣超
     * @date 18:40 2022/7/31
     */
    private UserAccountDto getUserAccountDto(LoginDto loginDto) throws UserException {
        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setMobile(loginDto.getMobile());
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