// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:14
// +----------------------------------------------------------------------
package os.api.v2.api.user.service.user.impl;

import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import os.api.v2.api.user.dto.user.IndexDto;
import os.api.v2.api.user.service.user.IUserIndexService;
import os.api.v2.api.user.vo.user.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.user.dto.user.IndexModelDto;
import os.api.v2.model.service.user.vo.user.IndexModelVo;

/**
 * os.api.v2.api.user.service.user.impl.UserIndexServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:14
 */
@Service
public class UserIndexServiceImpl implements IUserIndexService {
    @DubboReference(version = "2.0.0")
    protected os.api.v2.model.service.user.service.user.IUserIndexService iUserIndexService;

    @Override
    public Result<IndexDto> index(IndexVo indexVo) {
        IndexModelVo indexModelVo = new IndexModelVo();
        BeanUtils.copyProperties(indexVo, indexModelVo);
        Result<IndexModelDto> result = iUserIndexService.index(indexModelVo);
        IndexDto indexDto = new IndexDto();
        BeanUtils.copyProperties(result.getData(), indexDto);
        return new Result<>(Result.SUCCESS, indexDto);
    }
}
