// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 20:02
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.utils.jwt.JwtUtils;

import java.util.concurrent.TimeUnit;

/**
 * os.api.v2.api.user.controller
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 20:02
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    protected StringRedisTemplate redisTemplate;

    @Value("${custom.jwt.expire_time}")
    private long expireTime;

    @RequestMapping(value = "/getToken", method = RequestMethod.POST)
    public Result<String> index() {
        String token = JwtUtils.sign("xsy");
        if (token == null) {
            return new Result<>(Result.FAILURE, "服务器异常，获取token失败");
        }
        redisTemplate.opsForValue().set(token, token, expireTime * 2 / 100, TimeUnit.SECONDS);
        return new Result<>(Result.SUCCESS, token);
    }

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public Result<String> aaa() {
        return new Result<>(Result.SUCCESS, "666");
    }
}
