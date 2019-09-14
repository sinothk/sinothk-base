package com.sinothk.base.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    // 过期时间15天
    private static final long EXPIRE_TIME = 15 * 24 * 60 * 60 * 1000;
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

    public static String createToken(String userName) {
        try {
            return Jwts.builder().setSubject(SUBJECT)
                    .claim("", userName)
                    .setIssuedAt(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                    .signWith(SignatureAlgorithm.HS256, APP_SECRET).compact();
        } catch (Exception e) {
            return null;
        }
    }
}
