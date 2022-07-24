// +----------------------------------------------------------------------
// | 
// +----------------------------------------------------------------------
// | Copyright © 2022 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-06 9:50
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils;

import os.api.v2.common.base.utils.rsa.RsaUtils;

import java.io.IOException;
import java.security.PrivateKey;

/**
 * os.api.v2.common.base.utils.PasswordRsaUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-06 09:50
 */
public class PasswordRsaUtils {

    private final static String privateKey =
            "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCnJyVpdDzkn3xz\n" +
                    "HNqczQmNaq5F5sVbHOGxVQZo2he8Vra2A3EtNTPh3kYDj1oWkKKY+g3BTKBs6lzi\n" +
                    "ArYSHT8ZdXlK/Juc2KIR1mPROiMdTM8mB/+AnvZI46rvx+IlBIE1aGqDRT6Pjy0l\n" +
                    "JDjOZAvyVZ9Tg0sWSJJz4sxj4LxJi7tfqNQQBgkua06cUsIXRrqMb3PGTLfzy6Ok\n" +
                    "2ruxGnnx50UknGLfT3iRPk63mfkPnuDAfND8UNVjehGTRyuE46TnjyjiF0cAYRtH\n" +
                    "KUubYIAnL9IsPc3WBYHO177nDr47nOhQNSwml6nmYef2k/12l9Yn3z+TRTVJALKv\n" +
                    "pzcF0g5TAgMBAAECggEBAKOp77a+anUMN8VaZi8Lj6PY5cRpvamFsPJ6Jul5Sa5O\n" +
                    "VV4IJsO2CRPKGFGaBgJ8IciZZehzh8y8+K8PKoi3/DWIUXf7uL4tWxsOCPQu8XzZ\n" +
                    "3SYGxMSCYPFjgdZ/p0zJiV3q3AemQCg+b1yjh7+GNDBWZ8dUkavC6Srw0WGmBZYX\n" +
                    "1wTkU4hc6d4T7HXDpb5lMIiozppmqajQmrZaxBk0NVYDBkP/9MefgRjAlFwGZLNz\n" +
                    "mNj7l+x50/w4SeN5NwVXp3ohesgYTtbTykHqSwsKczn3sEuDjIm5ylUZnbdXXLzd\n" +
                    "wssZQ1hbUydeVO+5cuWxVx2lAwo1odbfK5rSwSGPhJECgYEA0SBq9bHLmwb7rVf1\n" +
                    "VsB+FXpRvLsfl1SSphthO9kxTj4Jn2EqsrqNvMZx17BYKIEk9KJDPt9J1ky0n2GU\n" +
                    "bOJg1/lWI+JC7TpP5VM57rwrl7Se7zoyeYZdMr9rX+wBQygsL++aRDAGZ70SU4Qy\n" +
                    "EoOXkdudkjmujsrwkgPtvE/PGRsCgYEAzJ5MGvceZTi/RwjZgnQrobdauIr5R7Rx\n" +
                    "CEPM+SCT5MwFRRANi54il0aMmN9gGYxlhN5O0rDKRmJuLhlRdKHKRsgagy8Pd4K4\n" +
                    "+K8QC2370lkkNVvq1LkU7gVbrQPJCH9hnAdeVxtwep0QMavhkPNHg/IkWhKuV/Y3\n" +
                    "uaOOgUfGqykCgYEAozLxRZvikLD6Z2RlCbZertQuRWKiXK6bYxWq49GzMKQpTj+9\n" +
                    "2ozLX65d2Ty9D575ABBA+ie2r45cxqSX+AESInlqR8ajBA6lmwlABJbETjeecIKy\n" +
                    "MTQyNxA68zhyI76N/Tq24M+5r+tVCef4S4p2FlWUujBZkQW+h7SZKoP90lECgYBL\n" +
                    "YCzM6ieKRiNAOaRWiBDim7aRsLAvl+rjjoZdZ4DTkcyHKmiy++fmLhjw36h5AN0M\n" +
                    "2w/SUUnSL8RCuxTkkA0BkgkiNh3OeptFEMgqTbOsQyYxedDB2AQ7wkGJNJHDzZjZ\n" +
                    "b2VzVSpUILOseJK5YMUBeBuoCqWqxYq1meiO+y/WMQKBgBTIL5BahbxNktVZGfQV\n" +
                    "1O44pk8adBBgLUO76U12gaLdMbUpE/Nok6k+Uy2z2HYD1NN5rtQBIBPpQ/6+DSjy\n" +
                    "MVkFwlbOYrgRqLF8j0GZ7b4hSG+GP6l6Nd5KO7Dmu9COn4rufUR0yf4SdOgd7cdi\n" +
                    "T+En9srcjHQkzbSQ5C+Nm4Xk";

    /**
     * 加密
     *
     * @param text String
     * @return java.lang.String
     * @author 吴荣超
     * @date 9:55 2022/7/6
     */
    public static String encode(String text) {
        return "";
    }

    /**
     * 解密
     *
     * @param encode String
     * @return java.lang.String
     * @author 吴荣超
     * @date 9:56 2022/7/6
     */
    public static String decode(String encode) {
        PrivateKey privateKey1 = null;
        try {
            privateKey1 = RsaUtils.string2PrivateKey(privateKey);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        //加密后的内容Base64解码
        byte[] base642Byte = new byte[0];
        try {
            base642Byte = RsaUtils.base642Byte(encode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //用私钥解密
        byte[] privateDecrypt;
        try {
            privateDecrypt = RsaUtils.privateDecrypt(base642Byte, privateKey1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return new String(privateDecrypt);
    }
}
