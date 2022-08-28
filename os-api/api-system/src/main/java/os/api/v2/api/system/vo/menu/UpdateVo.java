// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 16:43
// +----------------------------------------------------------------------
package os.api.v2.api.system.vo.menu;

import lombok.Data;

/**
 * os.api.v2.api.system.vo.menu.UpdateVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 16:43
 */
@Data
public class UpdateVo {

    private Long id;

    private Long moduleId;

    private Long parentId;

    private String uri;

    private String nameZh;

    private String nameEn;

    private Integer sorting;
}
