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
import org.springframework.web.bind.annotation.*;
import os.api.v2.api.user.dto.rolemodule.CreateDto;
import os.api.v2.api.user.dto.rolemodule.IndexDto;
import os.api.v2.api.user.service.rolemodule.*;
import os.api.v2.api.user.vo.rolemodule.*;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto;

import javax.validation.Valid;
import java.util.Map;

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

    @Autowired
    protected IRoleModuleOptionsService iRoleModuleOptionsService;

    @Autowired
    protected IRoleModuleCreateService iRoleModuleCreateService;

    @Autowired
    protected IRoleModuleStoreService iRoleModuleStoreService;

    @Autowired
    protected IRoleModuleEditService iRoleModuleEditService;

    @Autowired
    protected IRoleModuleUpdateService iRoleModuleUpdateService;

    @Autowired
    protected IRoleModuleDestroyService iRoleModuleDestroyService;

    @Autowired
    protected IRoleModulePermissionCreateService iRoleModulePermissionCreateService;

    @Autowired
    protected IRoleModulePermissionStoreService iRoleModulePermissionStoreService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public Result<IndexDto> index(IndexVo indexVo) {
        return iRoleModuleIndexService.index(indexVo);
    }

    @RequestMapping(value = "/options", method = RequestMethod.GET)
    public Result<Map<String, Object>> options() {
        return iRoleModuleOptionsService.options();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public Result<CreateDto> create() {
        return iRoleModuleCreateService.create();
    }

    @RequestMapping(value = "/store", method = RequestMethod.POST)
    public Result<String> store(@RequestBody @Valid StoreVo storeVo) {
        return iRoleModuleStoreService.store(storeVo);
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public Result<CreateDto> edit(EditVo editVo) {
        return iRoleModuleEditService.edit(editVo);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Result<RoleModuleModelDto> update(@RequestBody @Valid UpdateVo updateVo) {
        return iRoleModuleUpdateService.update(updateVo);
    }

    @RequestMapping(value = "/destroy", method = RequestMethod.POST)
    public Result<String> destroy(@RequestBody @Valid DestroyVo destroyVo) {
        return iRoleModuleDestroyService.destroy(destroyVo);
    }

    @RequestMapping(value = "permission", method = RequestMethod.GET)
    public Result<Map<String, Object>> permissionCreate(@RequestParam("id") Long id) throws UserException {
        return iRoleModulePermissionCreateService.permissionCreate(id);
    }

    @RequestMapping(value = "permission", method = RequestMethod.POST)
    public Result<String> permissionStore(@RequestBody @Valid PermissionStoreVo permissionStoreVo) {
        return iRoleModulePermissionStoreService.permissionStore(permissionStoreVo);
    }
}
