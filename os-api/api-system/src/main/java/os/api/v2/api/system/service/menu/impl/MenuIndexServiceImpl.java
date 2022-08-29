// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 10:25
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.menu.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.menu.IndexDto;
import os.api.v2.api.system.service.menu.IMenuIndexService;
import os.api.v2.api.system.vo.menu.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.common.base.exception.UserException;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;
import os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto;
import os.api.v2.model.service.system.service.menuoperate.IGetListByIdListService;
import os.api.v2.model.service.system.vo.menu.IndexModelVo;
import os.api.v2.service.service.user.service.menuoperate.IMenuOperateService;
import os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo;

import java.util.*;

/**
 * os.api.v2.api.system.service.menu.impl.MenuIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 10:25
 */
@Service
public class MenuIndexServiceImpl implements IMenuIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.system.service.menu.IMenuIndexService iMenuIndexService;

    @DubboReference(version = "2.0.0")
    protected IMenuOperateService iMenuOperateService;

    @DubboReference(version = "2.0.0")
    protected IGetListByIdListService iGetListByIdListService;

    @Override
    public Result<List<IndexDto>> index(IndexVo indexVo) throws UserException {
        List<MenuModelDto> menuModelDtoList = getMenuModelDtoList(indexVo);
        // 获取数据操作权限ID
        List<Long> menuOperateIdList = getMenuOperateIdList();
        // 获取数据操作权限数据
        List<Map<String, Object>> menuOperateList = getMenuOperateList(menuOperateIdList);
        // 完善数据
        return complete(menuModelDtoList, menuOperateList);
    }

    /**
     * complete
     *
     * @param menuModelDtoList
     * @param menuOperateList
     * @return Result<List < IndexDto>>
     * @author 吴荣超
     * @date 11:47 2022/8/21
     */
    private Result<List<IndexDto>> complete(List<MenuModelDto> menuModelDtoList, List<Map<String, Object>> menuOperateList) {
        List<IndexDto> indexDtoList = new ArrayList<>();
        for (MenuModelDto menuModelDto : menuModelDtoList) {
            IndexDto indexDto = new IndexDto();
            BeanUtils.copyProperties(menuModelDto, indexDto);
            if (menuModelDto.getParentId() != 0) {
                indexDto.setHasChildren(1);
            }
            indexDto.setOpts(menuOperateList);
            indexDtoList.add(indexDto);
        }
        return new Result<>(Result.SUCCESS, process(indexDtoList));
    }

    /**
     * getMenuOperateList
     *
     * @param menuOperateIdList
     * @return List<Map < String, Object>>
     * @author 吴荣超
     * @date 11:43 2022/8/21
     */
    private List<Map<String, Object>> getMenuOperateList(List<Long> menuOperateIdList) {
        String[] fieldArray = {
                "location",
                "name_en",
                "name_zh",
        };
        Result<List<MenuOperateModelDto>> result = iGetListByIdListService.getListByIdList(menuOperateIdList, fieldArray);
        List<Map<String, Object>> mapList = new ArrayList<>();
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return mapList;
        }
        for (MenuOperateModelDto menuOperateModelDto : result.getData()) {
            if ("TABLE-BODY".equals(menuOperateModelDto.getLocation())) {
                Map<String, Object> map = new HashMap<>();
                map.put("nameEn", menuOperateModelDto.getNameEn());
                map.put("nameZh", menuOperateModelDto.getNameZh());
                mapList.add(map);
            }
        }
        return mapList;
    }

    /**
     * getMenuOperateIdList
     *
     * @return List<Integer>
     * @author 吴荣超
     * @date 11:42 2022/8/21
     */
    private List<Long> getMenuOperateIdList() {
        MenuOperateServiceVo menuOperateServiceVo = new MenuOperateServiceVo();
        menuOperateServiceVo.setRoleId(1);
        menuOperateServiceVo.setSystemModuleId(1100176417150205952L);
        menuOperateServiceVo.setSystemMenuId(1100177342397005824L);
        Result<List<Long>> result = iMenuOperateService.getSystemMenuOperateIdList(menuOperateServiceVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            return new ArrayList<>();
        }
        return result.getData();
    }

    /**
     * getMenuModelDtoList
     *
     * @param indexVo
     * @return List<MenuModelDto>
     * @author 吴荣超
     * @date 11:40 2022/8/21
     */
    private List<MenuModelDto> getMenuModelDtoList(IndexVo indexVo) throws UserException {
        IndexModelVo indexModelVo = new IndexModelVo();
        indexModelVo.setFieldArray(new String[]{});
        Result<List<MenuModelDto>> result = iMenuIndexService.index(indexModelVo);
        if (Objects.equals(result.getFlag(), Result.FAILURE)) {
            throw new UserException("没有数据");
        }
        return result.getData();
    }

    /**
     * process
     *
     * @param permissionServiceDtoList
     * @return List<IndexDto>
     * @author 吴荣超
     * @date 20:14 2022/8/29
     */
    public List<IndexDto> process(List<IndexDto> indexDtoList) {
        //存返回数据
        List<IndexDto> totalType = new ArrayList<>();
        //使用map来装前面查到的所有数据
        Map<Long, IndexDto> map = new HashMap<>();

        for (IndexDto p : indexDtoList) {
            map.put(p.getId(), p);
        }

        //遍历所有类型，如果是最顶级父类型就直接装, 然后用这个父类型的children集合取装取当前数据
        for (IndexDto p : indexDtoList) {
            if (p.getParentId() == 0) {
                totalType.add(p);
            } else {
                IndexDto parents = map.get(p.getParentId());
                parents.getChildren().add(p);
            }
        }
        return totalType;
    }
}
