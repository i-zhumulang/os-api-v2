// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-10 22:34
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.module;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.ModuleMapper;
import os.api.v2.model.impl.system.pojo.Module;
import os.api.v2.model.service.system.service.module.IStoreService;
import os.api.v2.model.service.system.vo.module.StoreModelVo;

/**
 * os.api.v2.model.impl.system.service.module.StoreServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-10 22:34
 */
@DubboService(version = "2.0.0")
public class StoreServiceImpl extends ServiceImpl<ModuleMapper, Module> implements IStoreService {
    @Override
    public Result<String> store(StoreModelVo storeModelVo) {
        Module entity = new Module();
        BeanUtils.copyProperties(storeModelVo, entity);
        int insert = getBaseMapper().insert(entity);
        if (insert > 0) {
            return new Result<>(Result.SUCCESS, "创建成功");
        }
        return new Result<>(Result.FAILURE, "创建失败");
    }
}
