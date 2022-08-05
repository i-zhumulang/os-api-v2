// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:13
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system.service.modulemenu;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.modulemenu.ModuleMenuModelDto;
import os.api.v2.service.service.system.dto.modulemenu.PermissionChildrenServiceDto;
import os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto;
import os.api.v2.service.service.system.service.modulemenu.IModuleMenuService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.system.service.modulemenu.ModuleMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:13
 */
@DubboService(version = "2.0.0")
public class ModuleMenuServiceImpl implements IModuleMenuService {

    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.modulemenu.IModuleMenuService iModuleMenuService;

    @Override
    public Result<List<PermissionServiceDto>> permission(List<Integer> idList) {
        String[] fieldArray = {
                "id",
                "parent_id",
                "name_zh",
                "uri",
        };
        Result<List<ModuleMenuModelDto>> result = iModuleMenuService.permission(idList, fieldArray);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), null);
        }

        List<PermissionServiceDto> permissionServiceDtoList = new ArrayList<>();
        for (ModuleMenuModelDto moduleMenuModelDto : result.getData()) {
            PermissionServiceDto permissionServiceDto = new PermissionServiceDto();
            BeanUtils.copyProperties(moduleMenuModelDto, permissionServiceDto);
            permissionServiceDtoList.add(permissionServiceDto);
        }
        List<PermissionServiceDto> process = process(permissionServiceDtoList);
        return new Result<>(Result.SUCCESS, process);
    }

    public List<PermissionServiceDto> process(List<PermissionServiceDto> permissionServiceDtoList) {
        //存返回数据
        List<PermissionServiceDto> totalType = new ArrayList<>();
        //使用map来装前面查到的所有数据
        Map<Integer, PermissionServiceDto> map = new HashMap<>();

        for (PermissionServiceDto p : permissionServiceDtoList) {
            map.put(p.getId(), p);
        }

        //遍历所有类型，如果是最顶级父类型就直接装, 然后用这个父类型的children集合取装取当前数据
        for (PermissionServiceDto p : permissionServiceDtoList) {
            if (p.getParentId() == 0) {
                totalType.add(p);
            } else {
                PermissionServiceDto parents = map.get(p.getParentId());
                parents.getChildren().add(p);
            }
        }
        return totalType;
    }
}
