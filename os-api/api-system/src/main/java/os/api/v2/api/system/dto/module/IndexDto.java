// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-07 18:56
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.module;

import lombok.Data;
import os.api.v2.model.service.system.dto.module.ModuleModelDto;

import java.util.List;

/**
 * os.api.v2.api.system.dto.module.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-07 18:56
 */
@Data
public class IndexDto {
    private ModuleModelDto data;
    private String opts;
}
