// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-05-07 17:50
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils.aes;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * os.api.v2.common.base.utils.aes.AesDeCryptUtils
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-05-07 17:50
 */
public class AesDeCryptUtils {
    private final AesResult aesResult = new AesResult();

    private final Base64.Decoder base64Decoder = Base64.getDecoder();

    /**
     *
     * @param str
     * @param key
     * @param iv
     * @return
     */
    public AesResult decode(String str, String key, String iv) {
        aesResult.setIv(iv);
        aesResult.setKey(key);
        this.setResult(str);
        return aesResult;
    }

    /**
     *
     * @param str
     */
    private void setResult(String str) {
        try {
            SecretKey secretKey = new SecretKeySpec(aesResult.getKeyBytes(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(aesResult.getIvBytes()));
            // 将加密并编码后的内容解码成字节数组
            byte[] byteContent = base64Decoder.decode(str);
            // 解密
            byte[] byteDecode = cipher.doFinal(byteContent);
            aesResult.setResult(new String(byteDecode, StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
