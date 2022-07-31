// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:42
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.modulemenuoperate;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.model.impl.user.mapper.ModuleMenuOperateMapper;
import os.api.v2.model.impl.user.pojo.ModuleMenuOperate;
import os.api.v2.model.service.user.service.modulemenuoperate.IModuleMenuOperateService;

/**
 * os.api.v2.model.impl.user.service.modulemenuoperate.ModuleMenuOperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:42
 */
@DubboService
public class ModuleMenuOperateServiceImpl extends ServiceImpl<ModuleMenuOperateMapper, ModuleMenuOperate> implements IModuleMenuOperateService {
}
