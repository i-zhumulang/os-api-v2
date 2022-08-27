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
import os.api.v2.api.system.service.menu.IMenuCreateService;
import os.api.v2.api.system.service.menu.IMenuIndexService;
import os.api.v2.api.system.service.menu.IMenuOperateService;
import os.api.v2.api.system.service.menu.IMenuStoreService;
import os.api.v2.api.system.vo.menu.IndexVo;
import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.api.system.vo.menu.StoreVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @Autowired
    protected IMenuOperateService iMenuOperateService;

    @Autowired
    protected IMenuCreateService iMenuCreateService;

    @Autowired
    protected IMenuStoreService iMenuStoreService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody IndexVo indexVo) throws UserException {
        return iMenuIndexService.index(indexVo);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<Map<Long, Map<String, Object>>> create() {
        return iMenuCreateService.create();
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Result<String> store(@RequestBody @Valid StoreVo storeVo) {
        return iMenuStoreService.store(storeVo);
    }

    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public Result<List<Map<String, Object>>> operate() {
        return iMenuOperateService.operate();
    }
}
