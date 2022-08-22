// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-21 11:00
// +----------------------------------------------------------------------
package os.api.v2.model.service.system.vo.menu;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.system.vo.menu.IndexModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-21 11:00
 */
@Data
public class IndexModelVo implements Serializable {

    /**
     * 所属模块
     */
    private Long moduleId;

    /**
     * 需要查询的字段
     */
    private String[] fieldArray;
}
