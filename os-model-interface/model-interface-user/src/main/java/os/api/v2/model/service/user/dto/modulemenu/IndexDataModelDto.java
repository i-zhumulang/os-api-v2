// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:34
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.modulemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.modulemenu.IndexDataModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:34
 */
@Data
public class IndexDataModelDto implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID(v2_system.module表ID)
     */
    private Long systemModuleId;

    /**
     * 菜单ID(v2_system.menu表ID)
     */
    private Long systemMenuId;
}
