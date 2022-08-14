// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-08-14 10:15
// +----------------------------------------------------------------------
package os.api.v2.common.auth.realm;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * os.api.v2.common.auth.realm.Profile
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-08-14 10:15
 */
@Data
public class Profile implements Serializable, AuthCachePrincipal {
    private Long id;

    private String mobile;

    private Map<String, Object> roles = new HashMap<>();

//    private List<String> roles = new ArrayList<>();

    private List<String> modules = new ArrayList<>();

    private List<String> menus = new ArrayList<>();

    private List<String> operates = new ArrayList<>();


    @Override
    public String getAuthCacheKey() {
        return null;
    }
}
