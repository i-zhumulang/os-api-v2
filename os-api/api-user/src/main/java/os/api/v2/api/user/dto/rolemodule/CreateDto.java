// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 23:02
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.rolemodule;

import lombok.Data;

import java.util.List;

/**
 * os.api.v2.api.user.dto.rolemodule.CreateDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 23:02
 */
@Data
public class CreateDto {
    private List<RoleDataDto> role;
    private List<ModuleDataDto> module;
}
