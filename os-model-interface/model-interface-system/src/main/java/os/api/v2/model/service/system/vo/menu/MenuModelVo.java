// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-08 23:31
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.vo.menu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.model.service.system.vo.menu.MenuModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-08 23:31
 */
@Data
public class MenuModelVo implements Serializable {
    private Long id;
    private List<Long> idList;
    private Long parentId;
    private String[] fieldArray;
}
