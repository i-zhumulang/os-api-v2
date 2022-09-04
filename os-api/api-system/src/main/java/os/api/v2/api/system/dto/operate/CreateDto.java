// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 21:08
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.operate;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.dto.operate.CreateDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 21:08
 */
@Data
public class CreateDto {
    private List<CreateModuleDto> module;
}
