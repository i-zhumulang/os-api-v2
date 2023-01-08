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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.dto.user.IndexDto;
import os.api.v2.api.user.service.user.*;
import os.api.v2.api.user.vo.user.IndexVo;
import os.api.v2.api.user.vo.user.PermissionVo;
import os.api.v2.api.user.vo.user.RegisterVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.service.service.system.dto.menu.PermissionServiceDto;

import javax.validation.Valid;
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

    @Autowired
    protected IPermissionService iPermissionService;

    @Autowired
    protected IRegisterService iRegisterService;

    @Autowired
    protected IUserIndexService iUserIndexService;

    @Autowired
    protected IUserOptionsService iUserOptionsService;

    @RequestMapping(value = "/module", method = RequestMethod.GET)
    public Result<List<Map<String, Object>>> module() throws UserException {
        return iModuleService.module();
    }

    @RequestMapping(value = "/permission", method = RequestMethod.GET)
    public Result<List<PermissionServiceDto>> permission(PermissionVo permissionVo) throws UserException {
        return iPermissionService.permission(permissionVo);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Result<Integer> register(@RequestBody @Valid RegisterVo registerVo) {
        return iRegisterService.register(registerVo);
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result<IndexDto> index(IndexVo indexVo) {
        return iUserIndexService.index(indexVo);
    }

    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public Result<Map<String, Object>> options() {
        return iUserOptionsService.options();
    }
}
