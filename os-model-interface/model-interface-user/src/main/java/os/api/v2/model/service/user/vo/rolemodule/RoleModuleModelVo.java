// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 22:49
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.rolemodule;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.rolemodule.RoleModuleModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 22:49
 */
@Data
public class RoleModuleModelVo implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID(v2_system.module表ID)
     */
    private Long systemModuleId;
}
