// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-05 22:27
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.vo.role;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.vo.role.IndexModelVo
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-05 22:27
 */
@Data
public class IndexModelVo implements Serializable {
    private String[] fieldArray;
}
