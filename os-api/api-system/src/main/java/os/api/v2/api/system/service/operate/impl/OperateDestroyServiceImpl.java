// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 21:10
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.operate.IOperateDestroyService;
import os.api.v2.api.system.vo.operate.OperateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IMenuOperateService;

/**
 * os.api.v2.api.system.service.operate.impl.OperateDestroyServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 21:10
 */
@Service
public class OperateDestroyServiceImpl implements IOperateDestroyService {
    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @Override
    public Result<String> destroy(OperateVo operateVo) {
        MenuOperateModelDto menuOperateModelDto = new MenuOperateModelDto();
        menuOperateModelDto.setId(operateVo.getId());
        return iMenuOperateService.destroy(menuOperateModelDto);
    }
}
