// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 16:51
// +----------------------------------------------------------------------
package os.api.v2.common.base.common;

import lombok.Data;

import java.io.Serializable;

/**
 * os.api.v2.common.base.common
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 16:51
 */
@Data
public class Result<T> implements Serializable {

    /**
     * 成功
     */
    public final static String SUCCESS = "Success";

    /**
     * 失败
     */
    public final static String FAILURE = "Failure";

    /**
     * 是否成功
     */
    private String flag;

    /**
     * 状态码
     */
    private Integer code = 0;

    /**
     * 消息提示
     */
    private String message = "";

    /**
     * 返回数据
     */
    private T data = null;

    /**
     * 默认成功无数据返回
     *
     * @author 吴荣超
     * @date 17:47 2022/5/7
     */
    public Result() {
        this.flag = "Success";
    }

    /**
     * 全参
     *
     * @param flag 是否成功
     * @param code 成功失败编码
     * @param message 提示信息
     * @param data 数据
     * @author 吴荣超
     * @date 17:47 2022/5/7
     */
    public Result(String flag, Integer code, String message, T data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 成功返回数据、或者返回失败的数据
     *
     * @param flag 是否成功
     * @param data 数据
     * @author 吴荣超
     * @date 17:47 2022/5/7
     */
    public Result(String flag, T data) {
        this.flag = flag;
        this.data = data;
    }

    /**
     * 返回成功信息、或者失败信息
     *
     * @param flag 是否成功
     * @param message 提示信息
     * @author 吴荣超
     * @date 17:47 2022/5/7
     */
    public Result(String flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    /**
     * 有编码的返回
     *
     * @param flag 是否成功
     * @param code 成功失败编码
     * @param message 提示信息
     * @author 吴荣超
     * @date 17:47 2022/5/7
     */
    public Result(String flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    /**
     * 成功失败
     *
     * @param flag 是否成功
     * @param message 提示信息
     * @param data  数据
     * @author 吴荣超
     * @date 19:18 2022/7/15
     */
    public Result(String flag, String message, T data) {
        this.flag = flag;
        this.message = message;
        this.data = data;
    }
}
