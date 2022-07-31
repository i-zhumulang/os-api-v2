// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-31 08:48
// +----------------------------------------------------------------------
package os.api.v2.model.impl.common.utils;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;

import java.util.function.Predicate;

/**
 * os.api.v2.model.impl.common.utils.FieldValuesUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-31 08:48
 */
public class FieldValuesUtils<T> {

    private Class<T> tClass = null;

    private String[] fieldArray = new String[0];

    public FieldValuesUtils(Class<T> tClass, String[] fieldArray) {
        this.tClass = tClass;
        this.fieldArray = fieldArray;
    }

    /**
     * queryWrapper
     *
     * @return LambdaQueryWrapper<T>
     * @author 吴荣超
     * @date 9:05 2022/7/31
     */
    public LambdaQueryWrapper<T> queryWrapper() {
        LambdaQueryWrapper<T> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        if (this.fieldArray.length > 0) {
            Predicate<TableFieldInfo> predicate = null;
            for (String field : this.fieldArray) {
                predicate = predicate == null ? p -> p.getColumn().equals(field) : predicate.or(p -> p.getColumn().equals(field));
            }
            lambdaQueryWrapper.select(this.tClass, predicate);
        }
        return lambdaQueryWrapper;
    }
}
