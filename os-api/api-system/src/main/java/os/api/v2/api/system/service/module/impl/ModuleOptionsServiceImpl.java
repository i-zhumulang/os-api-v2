// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 16:56
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.module.IModuleOptionsService;
import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.module.impl.ModuleOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 16:56
 */
@Service
public class ModuleOptionsServiceImpl implements IModuleOptionsService {
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
        menuOperateServiceVo.setSystemModuleId(1100176417150205952L);
        menuOperateServiceVo.setSystemMenuId(1100177341767860224L);
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
