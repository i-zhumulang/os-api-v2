// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:24
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.role;

import lombok.Data;
import os.api.v2.model.service.user.dto.role.RoleModelDto;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.dto.role.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:24
 */
@Data
public class IndexDto {
    private RoleModelDto data;
    private List<Map<String, Object>> opts;
}
