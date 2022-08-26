// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 08:03
// +----------------------------------------------------------------------
package os.api.v2.api.system.vo.module;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

/**
 * os.api.v2.api.system.vo.module.UpdateVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 08:03
 */
@Data
public class UpdateVo {

    /**
     * 主键
     */
    @Range(min = 1)
    private Long id;

    /**
     * 模块名称(英文)
     */
    @NotBlank(message = "模块名称(英文)不能为空")
    private String nameEn;

    /**
     * 模块名称(中文)
     */
    @NotBlank(message = "模块名称(中文)不能为空")
    private String nameZh;

    /**
     * 模块域名
     */
    @NotBlank(message = "模块域名不能为空")
    private String domain;

    /**
     * 模块首页
     */
    @NotBlank(message = "模块首页不能为空")
    private String homePage;

    /**
     * 排序
     */
    @Range(min = 0, max = 1024)
    private Integer sorting;
}
