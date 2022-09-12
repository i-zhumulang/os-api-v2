package os.api.v2.model.impl.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 角色-模块
 * </p>
 *
 * @author 吴荣超
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class RoleModule implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID(v2_system.module表ID)
     */
    private Long systemModuleId;

    /**
     * 菜单数量
     */
    private Integer count;

    /**
     * 排序
     */
    private Integer sorting;

}
