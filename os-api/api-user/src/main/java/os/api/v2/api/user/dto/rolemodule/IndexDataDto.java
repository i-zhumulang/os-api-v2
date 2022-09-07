// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:22
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.rolemodule;

import lombok.Data;

/**
 * os.api.v2.api.user.dto.rolemodule.IndexDataDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:22
 */
@Data
public class IndexDataDto {
    private Long id;
    private Integer roleId;
    private String roleName;
    private Long systemModuleId;
    private String systemModuleName;
}
