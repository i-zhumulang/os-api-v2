// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-28 13:00
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.menu;

import lombok.Data;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;

import java.util.Map;

/**
 * os.api.v2.api.system.dto.menu.EditDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-28 13:00
 */
@Data
public class CreateDto {
    private Map<Long, Map<String, Object>> modules;
    private MenuModelDto menuModelDto;
}
