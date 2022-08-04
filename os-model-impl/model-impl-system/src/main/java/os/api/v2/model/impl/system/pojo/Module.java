package os.api.v2.model.impl.system.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 模块
 * </p>
 *
 * @author 吴荣超
 * @since 2022-08-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Module implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 模块名称(英文)
     */
    private String nameEn;

    /**
     * 模块名称(中文)
     */
    private String nameZh;

    /**
     * 模块域名
     */
    private String domain;

    /**
     * 模块首页
     */
    private String homePage;

    /**
     * 排序
     */
    private Integer sorting;


}
