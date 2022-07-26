// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-26 20:03
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.user.controller.AuthController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-26 20:03
 */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    Result<Map<String, Object>> login() {
        return null;
    }
}