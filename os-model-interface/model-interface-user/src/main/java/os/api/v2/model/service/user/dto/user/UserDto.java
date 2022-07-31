// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:22
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.user;

import lombok.Data;

/**
 * os.api.v2.model.service.user.dto.user.UserDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:22
 */
@Data
public class UserDto {
    /**
     * 用户ID
     */
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
    private Long createdAt;
}
