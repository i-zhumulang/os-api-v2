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
import org.springframework.stereotype.Service;
import os.api.v2.api.system.dto.module.IndexDto;
import os.api.v2.api.system.service.module.IIndexService;
import os.api.v2.api.system.vo.module.IndexVo;
import os.api.v2.common.base.common.Result;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;
import os.api.v2.model.service.system.vo.module.IndexModelVo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public Result<List<IndexDto>> index(IndexVo indexVo) {
        IndexModelVo indexModelVo = new IndexModelVo();
        String[] filedArray = {};
        Result<List<ModuleModelDto>> index = iIndexService.index(indexModelVo, filedArray);
        if (Objects.equals(index.getFlag(), Result.FAILURE)) {
            return new Result<>(index.getFlag(), null);
        }
        List<IndexDto> indexDtoList = new ArrayList<>();
        for (ModuleModelDto moduleModelDto : index.getData()) {
            IndexDto indexDto = new IndexDto();
            indexDto.setData(moduleModelDto);
            indexDtoList.add(indexDto);
        }
        return new Result<>(index.getFlag(), indexDtoList);
    }
}
