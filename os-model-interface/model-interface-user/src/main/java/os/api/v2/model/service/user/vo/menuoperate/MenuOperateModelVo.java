// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 21:22
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.menuoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.menuoperate.MenuOperateModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 21:22
 */
@Data
public class MenuOperateModelVo implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 模块-菜单ID
     */
    private Integer moduleMenuId;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID
     */
    private Integer systemModuleId;

    /**
     * 菜单ID
     */
    private Integer systemMenuId;

    /**
     * 操作ID
     */
    private Integer systemMenuOperateId;


}
