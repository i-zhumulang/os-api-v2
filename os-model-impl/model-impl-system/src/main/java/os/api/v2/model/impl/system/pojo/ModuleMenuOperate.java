package os.api.v2.model.impl.system.pojo;

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
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ModuleMenuOperate implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 所属菜单
     */
    private Integer moduleMenuId;

    /**
     * 操作位置(TABLE-HEAD:表头,TABLE-BODY:表体)
     */
    private String location;

    /**
     * 权限标识
     */
    private String permissionIdentify;

    /**
     * 操作名称(英文)
     */
    private String nameEn;

    /**
     * 操作名称(中文)
     */
    private String nameZh;

    /**
     * 地址
     */
    private String uri;

    /**
     * 排序
     */
    private Integer sorting;


}
