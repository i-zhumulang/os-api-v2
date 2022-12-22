// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:43
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system.service.menuoperate;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;

import java.util.*;

/**
 * os.api.v2.service.impl.system.service.menuoperate.IGetListByIdListServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:43
 */
@DubboService(version = "2.0.0")
public class GetListByIdListServiceImpl implements IGetListByIdListService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menuoperate.IGetListByIdListService iGetListByIdListService;

    @Override
    public List<Map<String, Object>> getTableHeadListByIdList(List<Long> idList) {
        String[] fieldArray = {
                "location",
                "name_en",
                "name_zh",
                "type",
        };
        Result<List<MenuOperateModelDto>> result = iGetListByIdListService.getListByIdList(idList, fieldArray);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return mapList;
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
        return mapList;
    }

    @Override
    public List<Map<String, Object>> getTableBodyListByIdList(List<Long> idList) {
        String[] fieldArray = {
                "location",
                "name_en",
                "name_zh",
        };
        Result<List<MenuOperateModelDto>> result = iGetListByIdListService.getListByIdList(idList, fieldArray);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return mapList;
        }
        for (MenuOperateModelDto menuOperateModelDto : result.getData()) {
            if ("TABLE-BODY".equals(menuOperateModelDto.getLocation())) {
                Map<String, Object> map = new HashMap<>();
                map.put("nameEn", menuOperateModelDto.getNameEn());
                map.put("nameZh", menuOperateModelDto.getNameZh());
                mapList.add(map);
            }
        }
        return mapList;
    }
}
