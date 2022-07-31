// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:31
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.model.impl.user.mapper.UserMapper;
import os.api.v2.model.impl.user.pojo.User;
import os.api.v2.model.service.user.service.user.IUserService;

/**
 * os.api.v2.model.impl.user.service.user.UserServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:31
 */
@DubboService
public class UserServiceImpl  extends ServiceImpl<UserMapper, User> implements IUserService {
}
