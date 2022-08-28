// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 19:20
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.menu.IMenuDestroyService;
import os.api.v2.api.system.vo.menu.MenuVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.service.menu.IMenuService;
import os.api.v2.model.service.system.vo.menu.MenuModelVo;

/**
 * os.api.v2.api.system.service.menu.impl.MenuDestroyServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 19:20
 */
@Service
public class MenuDestroyServiceImpl implements IMenuDestroyService {
    @DubboReference(version = "2.0.0")
    protected IMenuService iMenuService;

    @Override
    public Result<String> destroy(MenuVo menuVo) {
        MenuModelVo menuModelVo = new MenuModelVo();
        menuModelVo.setId(menuVo.getId());
        return iMenuService.destroy(menuModelVo);
    }
}
