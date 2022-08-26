// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 00:11
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.vo.module;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.model.service.system.vo.module.ModleModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 00:11
 */
@Data
public class ModuleModelVo implements Serializable {

    /**
     * ID
     */
    private Long id;

    private List<Long> idList;

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

    /**
     * 查询字段
     */
    private String[] fieldArray;
}
