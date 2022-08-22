// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 22:51
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.rolemodule;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.rolemodule.RoleModuleModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 22:51
 */
@Data
public class RoleModuleModelDto implements Serializable {
    private Integer id;

    /**
     * 角色-模块ID
     */
    private Long roleModuleId;

    /**
     * 菜单ID(v2_system.menu表ID)
     */
    private Integer systemMenuId;
}
