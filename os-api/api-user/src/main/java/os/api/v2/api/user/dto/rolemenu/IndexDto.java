// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-14 21:53
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.rolemenu;

import lombok.Data;

import java.util.List;

/**
 * os.api.v2.api.user.dto.rolemenu.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-14 21:53
 */
@Data
public class IndexDto {
    private Long total;
    private List<IndexDataDto> data;
}
