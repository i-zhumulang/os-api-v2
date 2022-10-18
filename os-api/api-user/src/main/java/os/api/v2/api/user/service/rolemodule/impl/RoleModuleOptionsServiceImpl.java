// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 21:52
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.rolemodule.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.rolemodule.IRoleModuleOptionsService;
import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.roleoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.user.service.rolemodule.impl.RoleModuleOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 21:52
 */
@Service
public class RoleModuleOptionsServiceImpl implements IRoleModuleOptionsService {
    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<Map<String, Object>> options() {
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        Map<String, Object> map = new HashMap<>();
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        map.put("operate", menuOperateList);
        return new Result<>(Result.SUCCESS, map);
    }

    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417951318016L);
        menuOperateServiceVo.setSystemMenuId(1102873120315822080L);
        Result<List<Long>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableHeadListByIdList(menuOperateIdList);
    }
}
