// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:54
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.modulemenu;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.dto.modulemenu.IndexDataDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:54
 */
@Data
public class IndexDataDto {
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    private String roleName;

    /**
     * 模块ID(v2_system.module表ID)
     */
    private Long systemModuleId;

    private String systemModuleName;

    /**
     * 菜单ID(v2_system.menu表ID)
     */
    private Long systemMenuId;

    private String systemMenuName;

    private List<Map<String, Object>> opts;
}
