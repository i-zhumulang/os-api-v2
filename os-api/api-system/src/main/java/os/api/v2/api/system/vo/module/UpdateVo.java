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

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "参数缺失")
    private Integer id;

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
    @Min(value = 0, message = "排序必须大于0")
    @Max(value = 1024, message = "排序必须小于1024")
    private Integer sorting;
}
