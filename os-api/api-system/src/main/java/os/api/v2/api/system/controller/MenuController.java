// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 10:14
// +----------------------------------------------------------------------
package os.api.v2.api.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.system.dto.menu.IndexDto;
import os.api.v2.api.system.service.menu.IMenuIndexService;
import os.api.v2.api.system.vo.menu.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import java.util.List;

/**
 * os.api.v2.api.system.controller.MenuController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 10:14
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    protected IMenuIndexService iMenuIndexService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody IndexVo indexVo) throws UserException {
        return iMenuIndexService.index(indexVo);
    }
}
