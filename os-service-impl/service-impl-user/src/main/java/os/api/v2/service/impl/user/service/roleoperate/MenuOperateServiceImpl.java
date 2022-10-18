// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:59
// +----------------------------------------------------------------------
package os.api.v2.service.impl.user.service.roleoperate;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.roleoperate.RoleOperateModelDto;
import os.api.v2.model.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.model.service.user.vo.roleoperate.RoleOperateModelVo;
import os.api.v2.service.service.user.service.roleoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.roleoperate.MenuOperateServiceVo;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * os.api.v2.service.impl.user.service.roleoperate.MenuOperateServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:59
 */
@DubboService(version = "2.0.0")
public class MenuOperateServiceImpl implements IMenuOperateService {
    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @Override
    public Result<List<Long>> getSystemMenuOperateIdList(MenuOperateServiceVo menuOperateServiceVo) {
        RoleOperateModelVo roleOperateModelVo = new RoleOperateModelVo();
        BeanUtils.copyProperties(menuOperateServiceVo, roleOperateModelVo);
        String[] fieldArray = {"system_menu_operate_id"};
        Result<List<RoleOperateModelDto>> result = iRoleOperateService.systemMenuOperateList(roleOperateModelVo, fieldArray);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), null);
        }
        List<Long> collect = result.getData().stream().map(RoleOperateModelDto::getSystemMenuOperateId).collect(Collectors.toList());
        return new Result<>(Result.SUCCESS, collect);
    }
}
