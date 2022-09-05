// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:15
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.role;

import lombok.Data;

/**
 * os.api.v2.model.service.user.dto.role.RoleModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:15
 */
@Data
public class RoleModelDto {
    private Integer id;

    /**
     * 角色名称(英文)
     */
    private String nameEn;

    /**
     * 角色名称(中文)
     */
    private String nameZh;
}
