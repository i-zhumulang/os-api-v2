// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-04 23:58
// +----------------------------------------------------------------------
package os.api.v2.api.system.vo.operate;

import lombok.Data;

/**
 * os.api.v2.api.system.vo.operate.UpdateVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-04 23:58
 */
@Data
public class UpdateVo {
    private Long id;
    private Long moduleId;
    private Long menuId;
    private String location;
    private String permissionIdentify;
    private String nameEn;
    private String nameZh;
    private String uri;
    private Integer sorting;
}
