// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 00:21
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menuoperate;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.MenuOperateMapper;
import os.api.v2.model.impl.system.pojo.MenuOperate;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IMenuOperateUpdateService;
import os.api.v2.model.service.system.vo.menuoperate.UpdateModelVo;

/**
 * os.api.v2.model.impl.system.service.menuoperate.OperateUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 00:21
 */
@DubboService(version = "2.0.0")
public class MenuOperateUpdateServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IMenuOperateUpdateService {
    @Override
    public Result<MenuOperateModelDto> update(UpdateModelVo updateModelVo) {
        MenuOperate entity = new MenuOperate();
        BeanUtils.copyProperties(updateModelVo, entity);
        int i = getBaseMapper().updateById(entity);
        if (i == 0) {
            return new Result<>(Result.FAILURE, "更新失败");
        }
        MenuOperate menuOperate = getBaseMapper().selectById(updateModelVo.getId());
        MenuOperateModelDto menuOperateModelDto = new MenuOperateModelDto();
        BeanUtils.copyProperties(menuOperate, menuOperateModelDto);
        return new Result<>(Result.SUCCESS, "更新成功", menuOperateModelDto);
    }
}
