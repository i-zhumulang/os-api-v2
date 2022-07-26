// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 23:04
// +----------------------------------------------------------------------
package os.api.v2.api.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.user.dto.rolemenu.IndexDto;
import os.api.v2.api.user.service.rolemenu.IRoleMenuIndexService;
import os.api.v2.api.user.vo.rolemenu.IndexVo;
import os.api.v2.common.base.common.Result;

/**
 * os.api.v2.api.user.controller.RoleMenuController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 23:04
 */
@RestController
@RequestMapping("/role-menu")
public class RoleMenuController {
    @Autowired
    protected IRoleMenuIndexService iRoleMenuIndexService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<IndexDto> index(@RequestBody IndexVo indexVo) {
        return iRoleMenuIndexService.index(indexVo);
    }
}
