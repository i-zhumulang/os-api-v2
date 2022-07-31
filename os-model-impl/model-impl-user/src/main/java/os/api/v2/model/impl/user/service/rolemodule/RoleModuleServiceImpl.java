// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:39
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.rolemodule;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.model.impl.user.mapper.RoleModuleMapper;
import os.api.v2.model.impl.user.pojo.RoleModule;
import os.api.v2.model.service.user.service.rolemodule.IRoleModuleService;

/**
 * os.api.v2.model.impl.user.service.rolemodule.RoleModuleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:39
 */
@DubboService
public class RoleModuleServiceImpl extends ServiceImpl<RoleModuleMapper, RoleModule> implements IRoleModuleService {
}
