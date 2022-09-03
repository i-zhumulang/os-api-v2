// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 21:26
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.operate;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.dto.operate.CreateModuleDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 21:26
 */
@Data
public class CreateModuleDto {
    private Long id;
    private String nameZh;
    private List<CreateMenuDto> menuDto;
}
