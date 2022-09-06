// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:18
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.user;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.user.IndexModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:18
 */
@Data
public class IndexModelVo implements Serializable {
    private Integer offset;
    private Integer limit;

    private String mobile;
}
