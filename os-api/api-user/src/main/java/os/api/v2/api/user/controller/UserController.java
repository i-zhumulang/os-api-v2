// +----------------------------------------------------------------------
// |
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 20:02
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.service.user.IModuleService;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.utils.jwt.JwtUtils;

import java.util.List;
import java.util.Map;

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
    protected IModuleService iModuleService;

    @RequestMapping(value = "/aaa", method = RequestMethod.GET)
    public Result<String> aaa() {
        return new Result<>(Result.SUCCESS, "666");
    }

    @RequestMapping(value = "/module", method = RequestMethod.POST)
    public Result<List<Map<String, Object>>> module() {
        return iModuleService.module();
    }
}
