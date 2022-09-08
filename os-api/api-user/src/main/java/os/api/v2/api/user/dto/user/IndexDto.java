// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:12
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.user;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.user.dto.user.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:12
 */
@Data
public class IndexDto {
    private Long total;
    private List<IndexDataDto> data;
}
