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

import os.api.v2.common.base.utils.aes.AesDeCryptUtils;
import os.api.v2.common.base.utils.aes.AesEnCryptUtils;
import os.api.v2.common.base.utils.aes.AesResult;

/**
 * os.api.v2.common.base.utils.PasswordUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-05-07 17:52
 */
public class PasswordAesUtils {
    /**
     *  密码加密
     *
     * @param password 需要加密的字符串
     * @return os.api.v2.common.base.utils.aes.AesResult
     * @author 吴荣超
     * @date 21:46 2022/4/26
     */
    public static AesResult encode(String password) {
        return new AesEnCryptUtils().encrypt(password);
    }

    /**
     * 密码解密
     *
     * @param encodePassword 需要解密的数据
     * @param key 密钥
     * @param iv iv
     * @return os.api.v2.common.base.utils.aes.AesResult
     * @author 吴荣超
     * @date 21:46 2022/4/26
     */
    public static AesResult decode(String encodePassword, String key, String iv) {
        return new AesDeCryptUtils().decode(encodePassword, key, iv);
    }
}
