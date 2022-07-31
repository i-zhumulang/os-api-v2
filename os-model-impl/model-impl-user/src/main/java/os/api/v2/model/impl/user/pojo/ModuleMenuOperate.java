package os.api.v2.model.impl.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 模块-菜单-操作
 * </p>
 *
 * @author 吴荣超
 * @since 2022-07-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ModuleMenuOperate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID
     */
    private Integer roleId;

    /**
     * 模块ID
     */
    private Integer moduleId;

    /**
     * 所属菜单ID(二级菜单ID)
     */
    private Integer moduleMenuId;

    /**
     * 操作ID
     */
    private Integer moduleMenuOperateId;

    /**
     * 操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)
     */
    private String location;


}
