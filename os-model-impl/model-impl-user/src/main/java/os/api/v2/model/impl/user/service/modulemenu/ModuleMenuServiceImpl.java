// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:41
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.modulemenu;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.model.impl.user.mapper.ModuleMenuMapper;
import os.api.v2.model.impl.user.pojo.ModuleMenu;
import os.api.v2.model.service.user.service.modulemenu.IModuleMenuService;

/**
 * os.api.v2.model.impl.user.service.modulemenu.ModuleMenuServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:41
 */
@DubboService
public class ModuleMenuServiceImpl extends ServiceImpl<ModuleMenuMapper, ModuleMenu> implements IModuleMenuService {
}
