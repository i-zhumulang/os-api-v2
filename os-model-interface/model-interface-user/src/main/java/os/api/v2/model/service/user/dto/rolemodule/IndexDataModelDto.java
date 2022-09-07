// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:08
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.rolemodule;

import lombok.Data;

/**
 * os.api.v2.model.service.user.dto.rolemodule.IndexDataModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:08
 */
@Data
public class IndexDataModelDto {
    private Long id;
    private Integer roleId;
    private Long systemModuleId;
}
