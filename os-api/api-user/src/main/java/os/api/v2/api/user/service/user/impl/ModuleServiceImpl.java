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
import os.api.v2.common.base.utils.jwt.JwtUtils;
import os.api.v2.model.service.system.dto.module.ModuleDto;
import os.api.v2.model.service.user.service.userrole.IUserRoleService;

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
    protected os.api.v2.model.service.system.service.module.IModuleService iModuleService;

    @Override
    public Result<List<Map<String, Object>>> module() {
        Result<List<Integer>> result = iUserRoleService.getMultiModuleIdByUserId(getUserId());
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new Result<>(result.getFlag(), "暂无权限");
        }
        // 通过ID获取数据
        List<ModuleDto> moduleDtoList = getModuleByIdList(result.getData());
        // 返回处理结果
        return complete(moduleDtoList);
    }

    private Result<List<Map<String, Object>>> complete(List<ModuleDto> moduleDtoList) {
        List<Map<String, Object>> list = new ArrayList<>();
        for (ModuleDto moduleDto : moduleDtoList) {
            Map<String, Object> map = new HashMap<>();
            map.put("nameEn", moduleDto.getNameEn());
            map.put("nameZh", moduleDto.getNameZh());
            map.put("domain", moduleDto.getDomain());
            map.put("homePage", moduleDto.getHomePage());
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
    private List<ModuleDto> getModuleByIdList(List<Integer> id) {
        String[] fieldArray = {
                "name_en",
                "name_zh",
                "domain",
                "home_page"
        };
        Result<List<ModuleDto>> result = iModuleService.getByIdList(id, fieldArray);
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
