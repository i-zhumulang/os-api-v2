// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-12-21 23:00
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.vo.menuoperate;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.service.service.system.vo.menuoperate.MenuOperateServiceVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-12-21 23:00
 */
@Data
public class MenuOperateServiceVo implements Serializable {
    private Long id;
    private List<Long> idList;
    private Long menuId;
    private List<Long> menuIdList;
    private Long moduleId;
    private List<Long> moduleIdList;
}
