// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:32
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.user.IndexDataModelDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:32
 */
@Data
public class IndexDataModelDto implements Serializable {
    private Long id;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 姓名
     */
    private String name;

    /**
     * 创建时间
     */
    private String createdAtFormat;
}
