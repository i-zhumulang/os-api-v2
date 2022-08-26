package os.api.v2.api.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.system.dto.module.EditDto;
import os.api.v2.api.system.dto.module.IndexDto;
import os.api.v2.api.system.service.module.*;
import os.api.v2.api.system.vo.module.*;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    protected IIndexService iIndexService;

    @Autowired
    protected IStoreService iStoreService;

    @Autowired
    protected IUpdateService iUpdateService;

    @Autowired
    protected IOperateService iOperateService;

    @Autowired
    protected IDestroyService iDestroyService;

    //    @RequiresPermissions("SYSTEM:MODULE:INDEX")
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody @Valid IndexVo indexVo) throws UserException {
        return iIndexService.index(indexVo);
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Result<String> store(@RequestBody @Valid StoreVo storeVo) {
        return iStoreService.store(storeVo);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public Result<EditDto> edit(@RequestBody @Valid ModuleVo moduleVo) {
        return iUpdateService.edit(moduleVo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<ModuleModelDto> update(@RequestBody @Valid UpdateVo updateVo) {
        return iUpdateService.update(updateVo);
    }

    @RequestMapping(value = "/operate", method = RequestMethod.POST)
    public Result<List<Map<String, Object>>> operate() {
        return iOperateService.operate();
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public Result<String> destroy(@RequestBody ModuleVo moduleVo) {
        return iDestroyService.destroy(moduleVo);
    }
}
