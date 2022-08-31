// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-31 22:08
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.vo.menuoperate;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.system.vo.menuoperate.IndexModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-31 22:08
 */
@Data
public class IndexModelVo implements Serializable {
    private Long moduleId;
    private Long menuId;
    private String location;
    private String[] fieldArray;
}
