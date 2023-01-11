// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 00:24
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.rolemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.rolemenu.RoleMenuModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 00:24
 */
@Data
public class RoleMenuModelVo implements Serializable {

    private Long id;

    /**
     * 角色-模块ID
     */
    private Long roleModuleId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID
     */
    private Long systemModuleId;

    /**
     * 菜单ID(v2_system.menu表ID)
     */
    private Long systemMenuId;

    /**
     * 菜单等级(0:一级菜单,1:二级菜单)
     */
    private Integer grade;
}
