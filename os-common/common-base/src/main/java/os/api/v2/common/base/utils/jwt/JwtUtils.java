// +----------------------------------------------------------------------
// | com.common.os.utils
// +----------------------------------------------------------------------
// | Copyright © 2017 版权 All Rights Reserved.
// +----------------------------------------------------------------------
// | Author: 吴荣超
// +----------------------------------------------------------------------
// | Date  : 2022-07-24 17:01
// +----------------------------------------------------------------------
package os.api.v2.common.base.utils.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;

/**
 * os.api.v2.common.base.utils.jwt
 *
 * @author 吴荣超
 * @version 2.0.0
 * @date 2022-07-24 17:01
 */
@Slf4j
public class JwtUtils {
    /**
     * JWT验证过期时间 EXPIRE_TIME 分钟
     */
    private static final long EXPIRE_TIME = 30 * 60 * 1000;

    public static final String SECRET = "zhegelingpaiyoudianchang";

    /**
     * 生成token签名EXPIRE_TIME 分钟后过期
     *
     * @param userId 用户名(电话号码)
     * @return 加密的token
     */
    public static String sign(Long userId) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        Algorithm algorithm = Algorithm.HMAC256(SECRET);
        // 附带username信息
        String token = JWT.create().withClaim("userId", userId).withExpiresAt(date).sign(algorithm);
        String encodeToken = "";
        encodeToken = Base64.getEncoder().encodeToString(token.getBytes(StandardCharsets.UTF_8));
        return encodeToken;
    }

    /**
     * 校验token是否正确
     *
     * @param token 密钥
     * @return 是否正确
     */
    public static boolean verify(String token, Long userId) {
        try {
            String decoderToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            //根据密码生成JWT效验器
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm).withClaim("userId", userId).build();
            //效验TOKEN
            DecodedJWT jwt = verifier.verify(decoderToken);
            log.info("登录验证成功!");
            return true;
        } catch (Exception exception) {
            log.error("JwtUtil登录验证失败!");
            return false;
        }
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
    public static Long getUsername(String token) {
        try {
            String decoderToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            DecodedJWT jwt = JWT.decode(decoderToken);
            return jwt.getClaim("userId").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
    public static Long getUserId(String token) {
        try {
            String decoderToken = new String(Base64.getDecoder().decode(token), StandardCharsets.UTF_8);
            DecodedJWT jwt = JWT.decode(decoderToken);
            return jwt.getClaim("userId").asLong();
        } catch (JWTDecodeException e) {
            return null;
        }
    }
}
