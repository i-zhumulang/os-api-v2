// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 23:13
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.dto.role.IndexDto;
import os.api.v2.api.user.service.role.IRoleIndexService;
import os.api.v2.common.base.common.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.controller.RoleController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 23:13
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    @Autowired
    protected IRoleIndexService iRoleIndexService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index() {
        return iRoleIndexService.index();
    }
}
