// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:20
// +----------------------------------------------------------------------
package os.api.v2.model.impl.user.service.user;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.dubbo.config.annotation.DubboService;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.impl.common.utils.FieldValuesUtils;
import os.api.v2.model.impl.user.mapper.UserMapper;
import os.api.v2.model.impl.user.pojo.User;
import os.api.v2.model.service.user.dto.user.IndexDataModelDto;
import os.api.v2.model.service.user.dto.user.IndexModelDto;
import os.api.v2.model.service.user.service.user.IUserIndexService;
import os.api.v2.model.service.user.vo.user.IndexModelVo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.model.impl.user.service.user.UserIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:20
 */
@DubboService(version = "2.0.0")
public class UserIndexServiceImpl extends ServiceImpl<UserMapper, User> implements IUserIndexService {
    @Override
    public Result<IndexModelDto> index(IndexModelVo indexModelVo) {
        LambdaQueryWrapper<User> queryWrapper = queryWrapper(indexModelVo, new String[]{});
        Page<User> page = new Page<>();
        getBaseMapper().selectPage(page, queryWrapper);
        IndexModelDto indexModelDto = new IndexModelDto();
        indexModelDto.setTotal(page.getTotal());
        List<User> userList = page.getRecords();
        List<IndexDataModelDto> indexDataModelDtoList = new ArrayList<>();
        for (User user: userList) {
            IndexDataModelDto indexDataModelDto = new IndexDataModelDto();
            indexDataModelDto.setId(user.getId());
            indexDataModelDto.setName(user.getName());
            indexDataModelDto.setMobile(user.getMobile());
            // 时间转换时间戳
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            indexDataModelDto.setCreatedAtFormat(simpleDateFormat.format(user.getCreatedAt()));
            indexDataModelDtoList.add(indexDataModelDto);
        }
        indexModelDto.setData(indexDataModelDtoList);
        return new Result<>(Result.SUCCESS, indexModelDto);
    }

    private LambdaQueryWrapper<User> queryWrapper(IndexModelVo indexModelVo, String[] fieldArray) {
        LambdaQueryWrapper<User> queryWrapper = new FieldValuesUtils<>(User.class, fieldArray).queryWrapper();
        queryWrapper.eq(indexModelVo.getMobile() != null, User::getMobile, indexModelVo.getMobile());
        return queryWrapper;
    }
}
