// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 21:27
// +----------------------------------------------------------------------
package os.api.v2.model.impl.system.service.menuoperate;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.system.mapper.MenuOperateMapper;
import os.api.v2.model.impl.system.pojo.MenuOperate;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IOperateService;

/**
 * os.api.v2.model.impl.system.service.menuoperate.OperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 21:27
 */
@DubboService(version = "2.0.0")
public class OperateServiceImpl extends ServiceImpl<MenuOperateMapper, MenuOperate> implements IOperateService {
    @Override
    public Result<String> destroy(MenuOperateModelDto menuOperateModelDto) {
        int result = getBaseMapper().deleteById(menuOperateModelDto.getId());
        if (result > 0) {
            return new Result<>(Result.SUCCESS, "删除成功");
        }
        return new Result<>(Result.FAILURE, "删除失败");
    }
}
