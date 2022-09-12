// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-12 22:39
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.rolemodule.UpdateVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-12 22:39
 */
@Data
public class UpdateVo {
    private Long id;
    private Integer roleId;
    private Long systemModuleId;
}
