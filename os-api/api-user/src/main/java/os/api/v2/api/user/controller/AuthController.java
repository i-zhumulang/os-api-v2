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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.dto.auth.LoginDto;
import os.api.v2.api.user.service.auth.ILoginService;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import javax.validation.Valid;
import java.util.Map;

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
    @Autowired
    protected ILoginService iLoginService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<Map<String, Object>> login(@RequestBody @Valid LoginDto loginDto) throws UserException {
        return iLoginService.login(loginDto);
    }
}