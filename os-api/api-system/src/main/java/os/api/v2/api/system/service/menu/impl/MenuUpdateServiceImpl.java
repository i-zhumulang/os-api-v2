// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 16:44
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.menu.IMenuUpdateService;
import os.api.v2.api.system.vo.menu.UpdateVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.vo.menu.UpdateModelVo;

/**
 * os.api.v2.api.system.service.menu.impl.MenuUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 16:44
 */
@Service
public class MenuUpdateServiceImpl implements IMenuUpdateService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menu.IMenuUpdateService iMenuUpdateService;

    @Override
    public Result<MenuModelDto> update(UpdateVo updateVo) {
        UpdateModelVo updateModelVo = new UpdateModelVo();
        BeanUtils.copyProperties(updateVo, updateModelVo);
        return iMenuUpdateService.update(updateModelVo);
    }
}
