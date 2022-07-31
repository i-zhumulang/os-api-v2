package os.api.v2.model.impl.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 模块-菜单
 * </p>
 *
 * @author 吴荣超
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ModuleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 所属模块
     */
    private Integer moduleId;

    /**
     * 菜单ID
     */
    private Integer moduleMenuId;

    /**
     * 上级菜单ID
     */
    private Integer moduleMenuParentId;


}
