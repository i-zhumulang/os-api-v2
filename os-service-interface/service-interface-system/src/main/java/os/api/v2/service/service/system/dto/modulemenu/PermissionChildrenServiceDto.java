// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-06 01:21
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.dto.modulemenu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.service.service.system.dto.modulemenu.PermissionChildrenServiceDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-06 01:21
 */
@Data
public class PermissionChildrenServiceDto implements Serializable {
    private Integer id;
    private String nameZh;
    private String uri;
}
