// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:58
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.userrole;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.model.impl.user.mapper.UserRoleMapper;
import os.api.v2.model.impl.user.pojo.UserRole;
import os.api.v2.model.service.user.service.userrole.IUserRoleService;

/**
 * os.api.v2.model.impl.user.service.userrole.UserRoleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:58
 */
@DubboService(version = "2.0.0")
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {
}
