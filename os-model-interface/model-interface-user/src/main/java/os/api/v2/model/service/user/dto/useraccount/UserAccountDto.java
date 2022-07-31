// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:23
// +----------------------------------------------------------------------
package os.api.v2.model.service.user.dto.useraccount;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.model.service.user.dto.useraccount.UserAccountDto
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:23
 */
@Data
public class UserAccountDto implements Serializable {
    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 密码
     */
    private String authentication;

    /**
     * 加密用的盐
     */
    private String salt;

    /**
     * 一个非空初始化向量
     */
    private String iv;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 是否删除(0:否,1:是)
     */
    private Integer deletedState;
}
