// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-03 00:17
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.dto.module;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.system.dto.module.ModuleDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-03 00:17
 */
@Data
public class ModuleDto implements Serializable {
    private Integer id;

    /**
     * 模块名称(英文)
     */
    private String nameEn;

    /**
     * 模块名称(中文)
     */
    private String nameZh;

    /**
     * 模块域名
     */
    private String domain;

    /**
     * 模块首页
     */
    private String homePage;

    /**
     * 排序
     */
    private Integer sorting;
}
