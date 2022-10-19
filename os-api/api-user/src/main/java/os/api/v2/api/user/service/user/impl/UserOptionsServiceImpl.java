// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-09 00:02
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.user.IUserOptionsService;
import os.api.v2.common.base.common.Result;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.service.service.user.vo.roleoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.user.service.user.impl.UserOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-09 00:02
 */
@Service
public class UserOptionsServiceImpl implements IUserOptionsService {

    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<Map<String, Object>> options() {
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        Map<String, Object> map = new HashMap<>();
        map.put("operate", menuOperateList);
        return new Result<>(Result.SUCCESS, map);
    }

    /**
     * getMenuOperateIdList
     *
     * @return List<Long>
     * @author 吴荣超
     * @date 0:14 2022/9/9
     */
    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417951318016L);
        menuOperateServiceVo.setSystemMenuId(1102872191327817728L);
        Result<List<Long>> result = iRoleOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    /**
     * getMenuOperateList
     *
     * @param menuOperateIdList
     * @return List<Map<String,Object>>
     * @author 吴荣超
     * @date 0:14 2022/9/9
     */
    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableHeadListByIdList(menuOperateIdList);
    }
}
