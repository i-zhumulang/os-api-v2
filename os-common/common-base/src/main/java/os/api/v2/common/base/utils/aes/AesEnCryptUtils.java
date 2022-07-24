// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-05-07 17:49
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Random;

/**
 * os.api.v2.common.base.utils.aes.AesEnCryptUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-05-07 17:49
 */
public class AesEnCryptUtils {
    private final AesResult aesResult = new AesResult();

    private final Base64.Encoder base64Encoder = Base64.getEncoder();

    static {
        java.security.Security.setProperty("crypto.policy", "unlimited");
    }

    /**
     *
     *
     * @param str
     * @return com.common.os.utils.aes.AesResult
     * @author 吴荣超
     * @date 17:49 2022/5/7
     */
    public AesResult encrypt(String str) {
        aesResult.setKey(getSpecifyLengthString(32));
        aesResult.setIv(getSpecifyLengthString(16));
        this.setResult(str);
        return aesResult;
    }

    /**
     *
     *
     * @param str String
     * @author 吴荣超
     * @date 17:49 2022/5/7
     */
    private void setResult(String str) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesResult.getKeyBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, new IvParameterSpec(aesResult.getIvBytes()));
            // 获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteEncode = str.getBytes(StandardCharsets.UTF_8);
            // 根据密码器的初始化方式加密
            byte[] byteAES = cipher.doFinal(byteEncode);
            // 将加密后的数据转换为字符串
            aesResult.setResult(base64Encoder.encodeToString(byteAES));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     *
     * @param length
     * @return java.lang.String
     * @author 吴荣超
     * @date 17:49 2022/5/7
     */
    public static String getSpecifyLengthString(int length) {
        char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int numberLength = number.length;
        char[] lower = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        int lowerLength = lower.length;
        char[] upper = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int upperLength = upper.length;

        char[] tmp = new char[numberLength + lowerLength + upperLength];
        System.arraycopy(number, 0, tmp, 0, numberLength);
        System.arraycopy(lower, 0, tmp, numberLength, lowerLength);
        System.arraycopy(upper, 0, tmp, numberLength + lowerLength, upperLength);
        StringBuilder str = new StringBuilder();

        Random rand = new Random();
        for (int i = 0; i < length; i++) {
            str.append(tmp[rand.nextInt(tmp.length)]);
        }
        return str.toString();
    }
}
