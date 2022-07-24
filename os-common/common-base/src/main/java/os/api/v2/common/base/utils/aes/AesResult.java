// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-05-07 17:47
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils.aes;

/**
 * os.api.v2.common.base.utils.aes.AesResult
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-05-07 17:47
 */
public class AesResult {
    /**
     * key
     */
    private String key = "";

    /**
     * iv
     */
    private String iv = "";

    /**
     * result
     */
    private String result = "";

    /**
     *
     *
     * @return java.lang.String
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public String getKey() {
        return key;
    }

    /**
     *
     *
     * @param key
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     *
     *
     * @return java.lang.String
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public String getIv() {
        return iv;
    }

    /**
     *
     *
     * @param iv
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public void setIv(String iv) {
        this.iv = iv;
    }

    /**
     *
     *
     * @return java.lang.String
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public String getResult() {
        return result;
    }

    /**
     *
     *
     * @param result
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     *
     *
     * @return byte[]
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public byte[] getIvBytes() {
        return iv.getBytes();
    }

    /**
     *
     *
     * @return byte[]
     * @author 吴荣超
     * @date 17:48 2022/5/7
     */
    public byte[] getKeyBytes() {
        return key.getBytes();
    }
}
