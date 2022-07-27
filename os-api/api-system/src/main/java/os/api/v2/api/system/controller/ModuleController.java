package os.api.v2.api.system.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import os.api.v2.common.base.common.Result;

@RestController
@RequestMapping("/module")
public class ModuleController {
    @RequiresPermissions("user:showa")
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public Result<String> index() {
        return new Result<>(Result.SUCCESS, "成功");
    }
}
