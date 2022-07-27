// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-27 20:40
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.auth.controller.AuthController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-27 20:40
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<String> index() {
        return new Result<>(Result.SUCCESS, "成功");
    }
}