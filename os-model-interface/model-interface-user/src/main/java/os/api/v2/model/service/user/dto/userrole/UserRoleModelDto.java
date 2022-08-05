// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 23:45
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.userrole;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.userrole.UserRoleModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 23:45
 */
@Data
public class UserRoleModelDto implements Serializable {
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 创建时间
     */
    private Long createdAt;
}
