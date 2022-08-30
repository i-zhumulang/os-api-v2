// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:50
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.user;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.user.mapper.UserAccountMapper;
import os.api.v2.model.impl.user.mapper.UserMapper;
import os.api.v2.model.impl.user.pojo.User;
import os.api.v2.model.impl.user.pojo.UserAccount;
import os.api.v2.model.service.user.service.user.IRegisterService;
import os.api.v2.model.service.user.vo.user.RegisterModelVo;

/**
 * os.api.v2.model.impl.user.service.user.RegisterServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:50
 */
@DubboService(version = "2.0.0")
public class RegisterServiceImpl extends ServiceImpl<UserMapper, User> implements IRegisterService {
    @Autowired
    protected UserAccountMapper userAccountMapper;

    @GlobalTransactional
    @Override
    public Result<Integer> register(RegisterModelVo registerModelVo) {
        int a = this.storeUser(registerModelVo);
        int b = this.storeUserAccount(registerModelVo);
        return new Result<>(Result.SUCCESS, "注册成功");
    }

    private int storeUser(RegisterModelVo registerModelVo) {
        User entity = new User();
        entity.setId(registerModelVo.getId());
        entity.setMobile(registerModelVo.getMobile());
        entity.setCreatedAt(registerModelVo.getCreatedAt());
        return getBaseMapper().insert(entity);
    }

    private int storeUserAccount(RegisterModelVo registerModelVo) {
        UserAccount entity = new UserAccount();
        entity.setIv(registerModelVo.getIv());
        entity.setSalt(registerModelVo.getSalt());
        entity.setUserId(registerModelVo.getId());
        entity.setMobile(registerModelVo.getMobile());
        entity.setAuthentication(registerModelVo.getAuthentication());
        return userAccountMapper.insert(entity);
    }
}
