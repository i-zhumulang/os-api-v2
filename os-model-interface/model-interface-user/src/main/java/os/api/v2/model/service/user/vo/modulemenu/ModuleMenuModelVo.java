// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 00:24
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.modulemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.modulemenu.ModuleMenuModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 00:24
 */
@Data
public class ModuleMenuModelVo implements Serializable {

    private Integer id;

    /**
     * 角色-模块ID
     */
    private Integer roleModuleId;

    /**
     * 菜单ID(v2_system.menu表ID)
     */
    private Integer systemMenuId;
}
