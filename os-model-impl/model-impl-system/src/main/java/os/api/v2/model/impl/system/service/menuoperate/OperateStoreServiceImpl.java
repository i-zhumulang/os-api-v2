// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 22:47
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menuoperate;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.MenuOperateMapper;
import os.api.v2.model.impl.system.pojo.MenuOperate;
import os.api.v2.model.service.system.service.menuoperate.IOperateStoreService;
import os.api.v2.model.service.system.vo.menuoperate.StoreModelVo;

/**
 * os.api.v2.model.impl.system.service.menuoperate.OperateStoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 22:47
 */
@DubboService(version = "2.0.0")
public class OperateStoreServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IOperateStoreService {
    @Override
    public Result<String> store(StoreModelVo storeModelVo) {
        MenuOperate entity = new MenuOperate();
        BeanUtils.copyProperties(storeModelVo, entity);
        int insert = getBaseMapper().insert(entity);
        if (insert > 0) {
            return new Result<>(Result.SUCCESS, "创建成功");
        }
        return new Result<>(Result.FAILURE, "创建失败");
    }
}
