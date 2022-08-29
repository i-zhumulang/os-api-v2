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
import os.api.v2.api.system.dto.menu.CreateDto;
import os.api.v2.api.system.dto.menu.IndexDto;
import os.api.v2.api.system.service.menu.*;
import os.api.v2.api.system.vo.menu.IndexVo;
import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.api.system.vo.menu.StoreVo;
import os.api.v2.api.system.vo.menu.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;

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
    protected IMenuCreateService iMenuCreateService;

    @Autowired
    protected IMenuStoreService iMenuStoreService;

    @Autowired
    protected IMenuEditService iMenuEditService;

    @Autowired
    protected IMenuUpdateService iMenuUpdateService;

    @Autowired
    protected IMenuDestroyService iMenuDestroyService;

    @Autowired
    protected IMenuOptionsService iMenuOptionsService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody IndexVo indexVo) throws UserException {
        return iMenuIndexService.index(indexVo);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<CreateDto> create() {
        return iMenuCreateService.create();
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Result<String> store(@RequestBody @Valid StoreVo storeVo) {
        return iMenuStoreService.store(storeVo);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<CreateDto> edit(@RequestBody @Valid MenuVo menuVo) {
        return iMenuEditService.edit(menuVo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<MenuModelDto> update(@RequestBody @Valid UpdateVo updateVo) {
        return iMenuUpdateService.update(updateVo);
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public Result<String> destroy(@RequestBody MenuVo menuVo) {
        return iMenuDestroyService.destroy(menuVo);
    }

    @RequestMapping(value = "/options", method = RequestMethod.POST)
    public Result<Map<String, Object>> options() {
        return iMenuOptionsService.options();
    }
}
