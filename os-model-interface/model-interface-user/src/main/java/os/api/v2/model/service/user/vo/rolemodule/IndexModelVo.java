// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:06
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.rolemodule;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.rolemodule.IndexModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:06
 */
@Data
public class IndexModelVo implements Serializable {
    private Integer offset;
    private Integer limit;
    private Integer roleId;
    private Long systemModuleId;
}
