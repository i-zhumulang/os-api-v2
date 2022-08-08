// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-02 23:34
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.service.user.IModuleService;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.common.base.utils.jwt.JwtUtils;
import os.api.v2.model.service.user.service.userrole.IUserRoleService;
import os.api.v2.service.service.system.dto.module.ModuleServiceDto;
import os.api.v2.service.service.system.vo.module.ModuleServiceVo;

import java.util.*;

/**
 * os.api.v2.api.user.service.user.impl.ModuleServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-02 23:34
 */
@Service
public class ModuleServiceImpl implements IModuleService {

    @DubboReference(version = "2.0.0")
    protected IUserRoleService iUserRoleService;

    @DubboReference(version = "2.0.0")
    protected os.api.v2.service.service.system.service.module.IModuleService iModuleService;

    @Override
    public Result<List<Map<String, Object>>> module() throws UserException {
        Result<List<Integer>> result = iUserRoleService.getMultiModuleIdByUserId(getUserId());
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), "暂无权限");
        }
        // 通过ID获取数据
        List<ModuleServiceDto> moduleByIdList = getModuleByIdList(result.getData());
        // 返回处理结果
        return complete(moduleByIdList);
    }

    private Result<List<Map<String, Object>>> complete(List<ModuleServiceDto> moduleModelDtoList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ModuleServiceDto moduleServiceDto : moduleModelDtoList) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", moduleServiceDto.getId());
            map.put("nameEn", moduleServiceDto.getNameEn());
            map.put("nameZh", moduleServiceDto.getNameZh());
            map.put("domain", moduleServiceDto.getDomain());
            map.put("homePage", moduleServiceDto.getHomePage());
            list.add(map);
        }
        return new Result<>(Result.SUCCESS, list);
    }

    /**
     * getModuleByIdList
     *
     * @param id array
     * @return List<ModuleDto>
     * @author 吴荣超
     * @date 0:26 2022/8/3
     */
    private List<ModuleServiceDto> getModuleByIdList(List<Integer> id) throws UserException {
        ModuleServiceVo moduleServiceVo = new ModuleServiceVo();
        moduleServiceVo.setIdList(id);
        Result<List<ModuleServiceDto>> result = iModuleService.getModuleByIdList(moduleServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException("暂无权限:1001");
        }
        return result.getData();
    }

    /**
     * getUserId
     *
     * @return long
     * @author 吴荣超
     * @date 23:36 2022/8/2
     */
    public long getUserId() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principal = subject.getPrincipals();
        return JwtUtils.getUserId((String) principal.getPrimaryPrincipal());
    }
}
