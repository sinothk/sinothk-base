package com.sinothk.base.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JWTUtil {

//    public static void main(String[] args) {
//
//        String token = JWTUtil.sign("liangyt", "123456");
//        System.out.println("token = " + token);
//
////        System.out.println("UserAccount = " + JWTUtil.getUserAccount(token));
//        System.out.println("Username = " + JWTUtil.getUsername(token));
//
//        boolean isOk = JWTUtil.verify(token, "liangyt", "123456");
//        System.out.println("验证 = " + isOk);
//    }

    /**
     * 校验token是否正确
     *
     * @param token  密钥
     * @param secret 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();

            DecodedJWT jwt = verifier.verify(token);
            return true;

        } catch (Exception exception) {
            return false;
        }
    }

    // 过期时间15天
    private static final long EXPIRE_TIME = 15 * 24 * 60 * 60 * 1000;

    /**
     * 生成签名,5min后过期
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return 加密的token
     */
    public static String sign(String username, String secret) {
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);

        Algorithm algorithm = Algorithm.HMAC256(secret);
        // 附带username信息
        return JWT.create()
//                .withClaim("account", "15285536453")
                .withClaim("username", username)
                .withExpiresAt(date)
                .sign(algorithm);
    }

    /**
     * 获得token中的信息无需secret解密也能获得
     *
     * @return token中包含的用户名
     */
//    @Deprecated
//    public static String getUserAccount(String token) {
//        try {
//            DecodedJWT jwt = JWT.decode(token);
//            return jwt.getClaim("account").asString();
//        } catch (JWTDecodeException e) {
//            return null;
//        }
//    }

    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

}
