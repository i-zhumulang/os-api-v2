// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-12-21 22:24
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.dto.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.service.service.system.dto.menu.MenuServiceDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-12-21 22:24
 */
@Data
public class MenuServiceDto implements Serializable {
    private Long id;

    /**
     * 上级菜单ID
     */
    private Long parentId;

    /**
     * 所属模块
     */
    private Long moduleId;

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
