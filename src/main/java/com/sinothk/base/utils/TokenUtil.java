package com.sinothk.base.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    // 过期时间15天
    private static final long EXPIRE_TIME = 60 * 1000;//15 * 24 * 60 * 60 * 1000; //
    private static final String SUBJECT = "gclass";
    private static final String APP_SECRET = "xd666";

    /**
     * 检查Token
     *
     * @param token
     * @return
     */
    public static Claims checkToken(String token) {
        try {
            return Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
    }

    public static String createToken(long expiryTime, String userName) {
        try {// https://www.cnblogs.com/zjutzz/p/5790180.html
            return Jwts.builder().setSubject(SUBJECT)
                    .claim("userName", userName)
                    .setExpiration(new Date(System.currentTimeMillis() + expiryTime))
                    .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
        } catch (Exception e) {
            return null;
        }
    }

    public static String getUserName(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        } catch (JWTDecodeException e) {
            return null;
        }
    }

    public static void main(String[] args) {

        String token = TokenUtil.createToken(EXPIRE_TIME, "liangyt");
        System.out.println("token = " + token);

//        String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJnY2xhc3MiLCJ1c2VyTmFtZSI6ImxpYW5neXQiLCJleHAiOjE1Njg0Nzg2MTl9.Lpw7SoGUo7xZ0GoHfxubyvyReUdvk8osqDszF5mzB7Q";
        Claims claims = TokenUtil.checkToken(token);

        if (claims == null) {
            // 错误token，超时都返回null
            System.out.println("验证失败");
        } else {
            System.out.println("验证通过");
            System.out.println("userName = " + TokenUtil.getUserName(token));
        }
    }
}
