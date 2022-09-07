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

import java.util.List;

/**
 * os.api.v2.api.user.dto.rolemodule.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-07 22:22
 */
@Data
public class IndexDto {
    private Long total;
    private List<IndexDataDto> data;
}
