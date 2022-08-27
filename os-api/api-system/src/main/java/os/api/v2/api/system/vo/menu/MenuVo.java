// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-27 21:31
// +----------------------------------------------------------------------
package os.api.v2.api.system.vo.menu;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * os.api.v2.api.system.vo.menu.MenuVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-27 21:31
 */
@Data
public class MenuVo {
    @NotNull
    private Long id;
}
