// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-30 22:46
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.user.IRegisterService;
import os.api.v2.api.user.vo.user.RegisterVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.utils.IdWorkerUtils;
import os.api.v2.common.base.utils.PasswordRsaUtils;
import os.api.v2.common.base.utils.QTimerUtils;
import os.api.v2.common.base.utils.aes.AesEnCryptUtils;
import os.api.v2.common.base.utils.aes.AesResult;
import os.api.v2.model.service.user.vo.user.RegisterModelVo;

/**
 * os.api.v2.api.user.service.user.impl.RegisterServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-30 22:46
 */
@Service
public class RegisterServiceImpl implements IRegisterService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.user.IRegisterService iRegisterService;

    @Override
    public Result<Integer> register(RegisterVo registerVo) {
        AesResult result = new AesEnCryptUtils().encrypt(PasswordRsaUtils.decode(registerVo.getPassword()));
        RegisterModelVo registerModelVo = new RegisterModelVo();
        registerModelVo.setId(new IdWorkerUtils().nextId());
        registerModelVo.setIv(result.getIv());
        registerModelVo.setSalt(result.getKey());
        registerModelVo.setAuthentication(result.getResult());
        registerModelVo.setMobile(registerVo.getMobile());
        registerModelVo.setCreatedAt(QTimerUtils.instance().getTime());
        return iRegisterService.register(registerModelVo);
    }
}
