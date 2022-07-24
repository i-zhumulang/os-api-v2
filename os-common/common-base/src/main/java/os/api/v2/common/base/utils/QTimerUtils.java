// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-05-07 17:52
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils;

import lombok.Data;

/**
 * os.api.v2.common.base.utils.QTimerUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-05-07 17:52
 */
@Data
public class QTimerUtils {
    private long time;

    /**
     * 获取当前时间
     *
     * @author 吴荣超
     * @date 23:39 2022/4/28
     */
    private QTimerUtils() {
        this.time = System.currentTimeMillis();
    }

    /**
     * 获取当前类实例
     *
     * @return com.api.common.utils.QTimerUtils
     * @author 吴荣超
     * @date 23:39 2022/4/28
     */
    public static QTimerUtils instance() {
        return new QTimerUtils();
    }
}
