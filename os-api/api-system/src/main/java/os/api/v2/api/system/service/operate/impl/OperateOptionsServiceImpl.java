// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-01 22:44
// +----------------------------------------------------------------------
package os.api.v2.api.system.service.operate.impl;

import org.springframework.stereotype.Service;
import os.api.v2.api.system.service.operate.IOperateOptionsService;
import os.api.v2.common.base.common.Result;

import java.util.Map;

/**
 * os.api.v2.api.system.service.operate.impl.OperateOptionsServiceImpl
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-01 22:44
 */
@Service
public class OperateOptionsServiceImpl implements IOperateOptionsService {
    @Override
    public Result<Map<String, Object>> options() {
        return null;
    }
}
