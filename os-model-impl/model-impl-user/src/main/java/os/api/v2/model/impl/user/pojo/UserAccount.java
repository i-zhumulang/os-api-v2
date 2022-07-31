package os.api.v2.model.impl.user.pojo;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户-账号表
 * </p>
 *
 * @author 吴荣超
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户ID
     */
    @TableId(value = "user_id", type = IdType.INPUT)
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
