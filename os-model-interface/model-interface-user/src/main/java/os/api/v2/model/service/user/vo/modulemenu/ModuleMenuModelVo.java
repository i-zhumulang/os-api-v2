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
     * 角色ID
     */
    private Integer roleId;

    /**
     * 所属模块
     */
    private Integer moduleId;

    /**
     * 菜单ID
     */
    private Integer moduleMenuId;
}
