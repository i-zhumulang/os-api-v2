// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:11
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.vo.modulemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.service.service.system.vo.modulemenu.ModuleMenuServiceVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:11
 */
@Data
public class ModuleMenuServiceVo implements Serializable {
    private Integer id;

    /**
     * 上级菜单ID
     */
    private Integer parentId;

    /**
     * 所属模块
     */
    private Integer moduleId;
}
