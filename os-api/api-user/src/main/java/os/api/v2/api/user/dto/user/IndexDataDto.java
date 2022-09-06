// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-09-06 22:17
// +----------------------------------------------------------------------
package os.api.v2.api.user.dto.user;

import lombok.Data;

/**
 * os.api.v2.api.user.dto.user.IndexDataDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-09-06 22:17
 */
@Data
public class IndexDataDto {
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
