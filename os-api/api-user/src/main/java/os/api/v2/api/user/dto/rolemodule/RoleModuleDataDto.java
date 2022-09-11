// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 18:04
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.dto.rolemodule.RoleModuleDataDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 18:04
 */
@Data
public class RoleModuleDataDto {
    private Long id;
    private Integer roleId;
    private Long systemModuleId;
}
