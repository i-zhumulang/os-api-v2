// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 15:54
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.vo.module;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.system.vo.module.UpdateModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 15:54
 */
@Data
public class UpdateModelVo implements Serializable {

    private Long id;

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
