// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:20
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.dto.modulemenu;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * os.api.v2.service.service.system.dto.modulemenu.PermissionServiceDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:20
 */
@Data
public class PermissionServiceDto implements Serializable {
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


    private List<PermissionServiceDto> children = new ArrayList<>();
}
