// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 00:36
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.module.IOperateService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.module.impl.OperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 00:36
 */
@Service
public class OperateServiceImpl implements IOperateService {

    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<List<Map<String, Object>>> operate() {
        // 获取数据操作权限ID
        List<Integer> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        return getMenuOperateList(menuOperateIdList);
    }

    /**
     * 获取数据操作权限ID
     *
     * @return List<Integer>
     * @author 吴荣超
     * @date 0:54 2022/8/21
     */
    private List<Integer> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1);
        menuOperateServiceVo.setSystemMenuId(2);
        Result<List<Integer>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    private Result<List<Map<String, Object>>> getMenuOperateList(List<Integer> menuOperateIdList) {
        String[] fieldArray = {
                "location",
                "name_en",
                "name_zh",
                "type",
        };
        Result<List<MenuOperateModelDto>> result = iGetListByIdListService.getListByIdList(menuOperateIdList, fieldArray);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), mapList);
        }
        for (MenuOperateModelDto menuOperateModelDto : result.getData()) {
            if ("TABLE-HEAD".equals(menuOperateModelDto.getLocation())) {
                Map<String, Object> map = new HashMap<>();
                map.put("nameEn", menuOperateModelDto.getNameEn());
                map.put("nameZh", menuOperateModelDto.getNameZh());
                map.put("type", menuOperateModelDto.getType());
                mapList.add(map);
            }
        }
        return new Result<>(result.getFlag(), mapList);
    }
}
