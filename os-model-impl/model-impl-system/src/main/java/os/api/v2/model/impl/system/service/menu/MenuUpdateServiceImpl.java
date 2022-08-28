// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 16:49
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menu;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.MenuMapper;
import os.api.v2.model.impl.system.pojo.Menu;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.service.menu.IMenuUpdateService;
import os.api.v2.model.service.system.vo.menu.UpdateModelVo;

/**
 * os.api.v2.model.impl.system.service.menu.MenuUpdateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 16:49
 */
@DubboService(version = "2.0.0")
public class MenuUpdateServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuUpdateService {
    @Override
    public Result<MenuModelDto> update(UpdateModelVo updateModelVo) {
        Menu entity = new Menu();
        BeanUtils.copyProperties(updateModelVo, entity);
        int i = getBaseMapper().updateById(entity);
        if (i == 0) {
            return new Result<>(Result.FAILURE, "更新失败");
        }
        Menu menu = getBaseMapper().selectById(updateModelVo.getId());
        MenuModelDto menuModelDto = new MenuModelDto();
        BeanUtils.copyProperties(menu, menuModelDto);
        return new Result<>(Result.SUCCESS, "更新成功", menuModelDto);
    }
}
