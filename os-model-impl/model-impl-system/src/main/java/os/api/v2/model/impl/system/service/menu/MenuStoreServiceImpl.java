// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 10:40
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menu;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.MenuMapper;
import os.api.v2.model.impl.system.pojo.Menu;
import os.api.v2.model.service.system.service.menu.IMenuStoreService;
import os.api.v2.model.service.system.vo.menu.StoreModelVo;

/**
 * os.api.v2.model.impl.system.service.menu.MenuStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 10:40
 */
@DubboService(version = "2.0.0")
public class MenuStoreServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuStoreService {
    @Override
    public Result<String> store(StoreModelVo storeModelVo) {
        Menu entity = new Menu();
        BeanUtils.copyProperties(storeModelVo, entity);
        int insert = getBaseMapper().insert(entity);
        if (insert > 0) {
            return new Result<>(Result.SUCCESS, "创建成功");
        }
        return new Result<>(Result.FAILURE, "创建失败");
    }
}
