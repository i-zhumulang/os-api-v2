// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-11 20:31
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.rolemodule;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.rolemodule.UpdateModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-11 20:31
 */
@Data
public class UpdateModelVo implements Serializable {
    private Long id;
    private Integer roleId;
    private Long systemModuleId;
}
