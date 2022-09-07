// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:21
// +----------------------------------------------------------------------
package os.api.v2.api.user.vo.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.vo.rolemodule.IndexVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:21
 */
@Data
public class IndexVo {
    private Integer offset;
    private Integer limit;
    private Integer roleId;
    private Long systemModuleId;
}
