// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:42
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.dto.rolemodule.IndexDto;
import os.api.v2.api.user.service.rolemodule.IRoleModuleIndexService;
import os.api.v2.api.user.vo.rolemodule.IndexVo;
import os.api.v2.common.base.common.Result;

import javax.validation.Valid;

/**
 * os.api.v2.api.user.controller.RoleModuleController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:42
 */
@RestController
@RequestMapping("/role-module")
public class RoleModuleController {
    @Autowired
    protected IRoleModuleIndexService iRoleModuleIndexService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<IndexDto> index(@RequestBody @Valid IndexVo indexVo) {
        return iRoleModuleIndexService.index(indexVo);
    }
}
