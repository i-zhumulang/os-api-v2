// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:34
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.rolemenu;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.model.service.user.dto.modulemenu.IndexModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:34
 */
@Data
public class IndexModelDto implements Serializable {
    private Long total;
    private List<IndexDataModelDto> data;
}
