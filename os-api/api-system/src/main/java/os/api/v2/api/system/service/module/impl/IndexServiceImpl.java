// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 17:59
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.module.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.module.IndexDto;
import os.api.v2.api.system.service.module.IIndexService;
import os.api.v2.api.system.vo.module.IndexVo;
import os.api.v2.common.auth.realm.Profile;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.vo.module.IndexModelVo;
import os.api.v2.service.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.service.service.user.service.roleoperate.IRoleOperateService;
import os.api.v2.service.service.user.vo.roleoperate.RoleOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.module.impl.IndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 17:59
 */
@Service
public class IndexServiceImpl implements IIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.module.IIndexService iIndexService;

    @DubboReference(version = "2.0.0")
    protected IRoleOperateService iRoleOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<List<IndexDto>> index(IndexVo indexVo) throws UserException {
        // 获取数据列表
        List<ModuleModelDto> moduleModelDtoList = getModuleModelDtoList();
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        // 完善数据
        return complete(moduleModelDtoList, menuOperateList);
    }

    /**
     * complete
     *
     * @param moduleModelDtoList
     * @param menuOperateList
     * @return Result<List<IndexDto>>
     * @author 吴荣超
     * @date 1:49 2022/8/10
     */
    private Result<List<IndexDto>> complete(List<ModuleModelDto> moduleModelDtoList, List<Map<String, Object>> menuOperateList) {
        List<IndexDto> indexDtoList = new ArrayList<>();
        for (ModuleModelDto moduleModelDto : moduleModelDtoList) {
            IndexDto indexDto = new IndexDto();
            indexDto.setData(moduleModelDto);
            indexDto.setOpts(menuOperateList);
            indexDtoList.add(indexDto);
        }
        return new Result<>(Result.SUCCESS, indexDtoList);
    }

    /**
     * getMenuOperateList
     * 
     * @param menuOperateIdList 
     * @return List<Map<String,Object>>
     * @author 吴荣超
     * @date 23:31 2022/8/9
     */
    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (menuOperateIdList.isEmpty()) {
            return mapList;
        }
        return iGetListByIdListService.getTableBodyListByIdList(menuOperateIdList);
    }

    /**
     * 获取数据操作权限ID
     *
     * @return List<Integer>
     * @author 吴荣超
     * @date 22:33 2022/8/9
     */
    private List<Long> getMenuOperateIdList() {
        RoleOperateServiceVo roleOperateServiceVo = new RoleOperateServiceVo();
        roleOperateServiceVo.setRoleId(1);
        roleOperateServiceVo.setSystemModuleId(1100176417150205952L);
        roleOperateServiceVo.setSystemMenuId(1100177341767860224L);
        Result<List<Long>> result = iRoleOperateService.getSystemMenuOperateIdList(roleOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    /**
     * 获取数据列表
     *
     * @return List<ModuleModelDto>
     * @author 吴荣超
     * @date 21:15 2022/8/9
     */
    private List<ModuleModelDto> getModuleModelDtoList() throws UserException {
        IndexModelVo indexModelVo = new IndexModelVo();
        String[] filedArray = {};
        Result<List<ModuleModelDto>> result = iIndexService.index(indexModelVo, filedArray);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException("没有数据");
        }
        return result.getData();
    }

    /**
     * 获取当前登录ID
     *
     * @return long
     * @author 吴荣超
     * @date 21:13 2022/8/9
     */
    public Long getUserId() {
        Subject subject = SecurityUtils.getSubject();
        PrincipalCollection principal = subject.getPrincipals();
        Profile profile = (Profile) principal.getPrimaryPrincipal();
        return profile.getId();
    }
}
