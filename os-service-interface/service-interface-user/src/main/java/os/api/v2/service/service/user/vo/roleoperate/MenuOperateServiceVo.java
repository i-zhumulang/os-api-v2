// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:55
// +----------------------------------------------------------------------
package os.api.v2.service.service.user.vo.roleoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.service.service.user.vo.menuoperate.MenuOperateServiceVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:55
 */
@Data
public class MenuOperateServiceVo implements Serializable {

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


}
