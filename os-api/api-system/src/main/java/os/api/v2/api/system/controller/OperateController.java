// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 21:58
// +----------------------------------------------------------------------
package os.api.v2.api.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.system.dto.operate.CreateDto;
import os.api.v2.api.system.dto.operate.IndexDto;
import os.api.v2.api.system.service.operate.*;
import os.api.v2.api.system.vo.operate.IndexVo;
import os.api.v2.api.system.vo.operate.OperateVo;
import os.api.v2.api.system.vo.operate.StoreVo;
import os.api.v2.api.system.vo.operate.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.controller.OperateController
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 21:58
 */
@RestController
@RequestMapping("/operate")
public class OperateController {
    @Autowired
    protected IOperateIndexService iOperateIndexService;

    @Autowired
    protected IOperateOptionsService iOperateOptionsService;

    @Autowired
    protected IOperateCreateService iOperateCreateService;

    @Autowired
    protected IOperateStoreService iOperateStoreService;

    @Autowired
    protected IOperateEditService iOperateEditService;

    @Autowired
    protected IOperateUpdateService iOperateUpdateService;

    @Autowired
    protected IOperateDestroyService iOperateDestroyService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody IndexVo indexVo) throws UserException {
        return iOperateIndexService.index(indexVo);
    }

    @RequestMapping(value = "/options", method = RequestMethod.POST)
    public Result<Map<String, Object>> options() {
        return iOperateOptionsService.options();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Result<CreateDto> create() {
        return iOperateCreateService.create();
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Result<String> store(@RequestBody @Valid StoreVo storeVo) {
        return iOperateStoreService.store(storeVo);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<CreateDto> edit() {
        return iOperateEditService.edit();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<MenuOperateModelDto> update(@RequestBody @Valid UpdateVo updateVo) {
        return iOperateUpdateService.update(updateVo);
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public Result<String> destroy(@RequestBody @Valid OperateVo operateVo) {
        return iOperateDestroyService.destroy(operateVo);
    }
}
