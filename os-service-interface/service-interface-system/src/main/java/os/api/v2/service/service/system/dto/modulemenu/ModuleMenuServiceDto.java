// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:09
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.dto.modulemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.service.service.system.dto.modulemenu.ModuleMenuServiceDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:09
 */
@Data
public class ModuleMenuServiceDto implements Serializable {
    private Integer id;

    /**
     * 上级菜单ID
     */
    private Integer parentId;

    /**
     * 所属模块
     */
    private Integer moduleId;

    /**
     * 英文名称
     */
    private String nameEn;

    /**
     * 中文名称
     */
    private String nameZh;

    /**
     * 地址
     */
    private String uri;

    /**
     * 排序
     */
    private Integer sorting;
}
