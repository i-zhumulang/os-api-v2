// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-13 00:00
// +----------------------------------------------------------------------
package os.api.v2.api.system.vo.module;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * os.api.v2.api.system.vo.module.EditVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-13 00:00
 */
@Data
public class EditVo {
    @Range(min = 1)
    private Long id;
}
