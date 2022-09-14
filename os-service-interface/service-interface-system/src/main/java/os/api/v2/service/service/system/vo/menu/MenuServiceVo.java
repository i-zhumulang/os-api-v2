// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 23:46
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.vo.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.service.service.system.vo.menu.MenuServiceVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 23:46
 */
@Data
public class MenuServiceVo implements Serializable {
    private Long id;
    private List<Long> idList;
}
