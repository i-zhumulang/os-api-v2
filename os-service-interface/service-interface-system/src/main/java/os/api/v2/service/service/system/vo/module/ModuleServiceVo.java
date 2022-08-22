// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-05 20:07
// +----------------------------------------------------------------------
package os.api.v2.service.service.system.vo.module;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * os.api.v2.service.service.system.vo.module.ModuleVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-05 20:07
 */
@Data
public class ModuleServiceVo implements Serializable {
    private List<Long> idList;
    private Integer id;
}