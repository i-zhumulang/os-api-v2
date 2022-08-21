// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 10:24
// +----------------------------------------------------------------------
package os.api.v2.api.system.dto.menu;

import lombok.Data;
import os.api.v2.model.service.system.dto.menu.MenuModelDto;

import java.util.List;
import java.util.Map;

/**
 * os.api.v2.api.system.dto.menu.IndexDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 10:24
 */
@Data
public class IndexDto {
    private MenuModelDto data;
    private List<Map<String, Object>> opts;
}
