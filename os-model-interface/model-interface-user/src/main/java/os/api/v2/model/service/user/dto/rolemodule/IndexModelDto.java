// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-07 22:07
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.rolemodule;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.model.service.user.dto.rolemodule.IndexModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:07
 */
@Data
public class IndexModelDto implements Serializable {
    private Long total;
    private List<IndexDataModelDto> data;
}
