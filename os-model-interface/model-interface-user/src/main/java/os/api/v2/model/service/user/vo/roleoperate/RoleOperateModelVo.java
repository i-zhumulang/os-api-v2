// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:22
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.roleoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.roleoperate.RoleOperateModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:22
 */
@Data
public class RoleOperateModelVo implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 模块-菜单ID
     */
    private Long moduleMenuId;

    /**
     * 角色ID
     */
    private Integer roleId;

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


}
