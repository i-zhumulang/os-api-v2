package os.api.v2.model.impl.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 菜单-操作
 * </p>
 *
 * @author 吴荣超
 * @since 2022-08-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuOperate implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模块-菜单ID
     */
    private Integer moduleMenuId;

    /**
     * 操作ID
     */
    private Integer systemMenuOperateId;

    /**
     * 排序
     */
    private Integer sorting;


}
