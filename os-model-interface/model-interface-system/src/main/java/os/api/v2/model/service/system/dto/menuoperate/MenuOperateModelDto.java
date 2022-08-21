// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-09 23:14
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.dto.menuoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.system.dto.menuoperate.MenuOperateModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-09 23:14
 */
@Data
public class MenuOperateModelDto implements Serializable {
    private Integer id;

    /**
     * 所属菜单
     */
    private Integer menuId;

    /**
     * 操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)
     */
    private String location;

    /**
     * element-plus button 对应type属性
     */
    private String type;

    /**
     * 权限标识
     */
    private String permissionIdentify;

    /**
     * 操作名称(英文)
     */
    private String nameEn;

    /**
     * 操作名称(中文)
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
