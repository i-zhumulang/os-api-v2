package os.api.v2.api.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.api.system.dto.module.IndexDto;
import os.api.v2.api.system.service.module.IIndexService;
import os.api.v2.api.system.vo.module.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @Autowired
    protected IIndexService iIndexService;
//    @RequiresPermissions("SYSTEM:MODULE:INDEX")
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<List<IndexDto>> index(@RequestBody @Valid IndexVo indexVo) throws UserException {
        return iIndexService.index(indexVo);
    }
}
