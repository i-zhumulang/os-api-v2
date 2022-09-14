// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 23:48
// +----------------------------------------------------------------------
package os.api.v2.service.impl.system.service.menu;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;
import os.api.v2.service.service.system.service.menu.IMenuService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.system.service.menu.IMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 23:48
 */
@DubboService(version = "2.0.0")
public class IMenuServiceImpl implements IMenuService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menu.IMenuService iMenuService;
    @Override
    public Result<Map<Long, String>> getMenuIdNameZhMap() {
        MenuModelVo menuModelVo = new MenuModelVo();
        menuModelVo.setFieldArray(new String[]{
                "id",
                "name_zh"
        });
        Result<List<MenuModelDto>> result = iMenuService.getMenuList(menuModelVo);
        Map<Long, String> idName = result.getData()
                .stream()
                .collect(
                        Collectors.toMap(
                                MenuModelDto::getId,
                                MenuModelDto::getNameZh
                        )
                );
        return new Result<>(Result.SUCCESS, idName);
    }
}
