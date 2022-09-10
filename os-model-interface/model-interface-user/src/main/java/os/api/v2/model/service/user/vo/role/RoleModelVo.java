// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-10 12:48
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.role;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.role.RoleModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-10 12:48
 */
@Data
public class RoleModelVo implements Serializable {
    private String[] fieldArray;
}
