// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-12-22 21:34
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.rolemodule;

import lombok.Data;

import java.util.List;

/**
 * os.api.v2.api.user.dto.rolemodule.PermissionCreateDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-12-22 21:34
 */
@Data
public class PermissionCreateDto {
    private Long id;
    private String label;
    private String type;
    private Long moduleId;
    private Long leaderId;
    private List<PermissionCreateDto> children;
}
