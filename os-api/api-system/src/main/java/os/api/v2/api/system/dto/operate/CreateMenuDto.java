// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-03 21:27
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.operate;

import lombok.Data;

import java.util.List;

/**
 * os.api.v2.api.system.dto.operate.CreateMenuDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-03 21:27
 */
@Data
public class CreateMenuDto {
    private Long id;
    private Long parentId;
    private Long moduleId;
    private String nameZh;
    private List<CreateMenuDto> children;
}
