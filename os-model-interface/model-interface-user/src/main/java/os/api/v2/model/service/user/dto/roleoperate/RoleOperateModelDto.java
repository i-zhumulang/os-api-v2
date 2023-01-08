// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:25
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.roleoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.menuoperate.MenuOperateModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:25
 */
@Data
public class RoleOperateModelDto implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 角色-模块ID
     */
    private Long roleModuleId;

    /**
     * 角色-菜单ID
     */
    private Long roleMenuId;

    /**
     * 模块ID
     */
    private Long systemModuleId;

    /**
     * 菜单ID
     */
    private Long systemMenuId;

    /**
     * 操作ID
     */
    private Long systemMenuOperateId;

    /**
     * 排序
     */
    private Integer sorting;
}
