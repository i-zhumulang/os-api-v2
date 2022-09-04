// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 00:13
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.operate.IOperateUpdateService;
import os.api.v2.api.system.vo.operate.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.vo.menuoperate.UpdateModelVo;

/**
 * os.api.v2.api.system.service.operate.impl.OperateUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 00:13
 */
@Service
public class OperateUpdateServiceImpl implements IOperateUpdateService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menuoperate.IOperateUpdateService iOperateUpdateService;

    @Override
    public Result<MenuOperateModelDto> update(UpdateVo updateVo) {
        UpdateModelVo updateModelVo = new UpdateModelVo();
        BeanUtils.copyProperties(updateVo, updateModelVo);
        return iOperateUpdateService.update(updateModelVo);
    }
}
