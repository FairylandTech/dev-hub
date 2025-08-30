/*****************************************************
 * @software: IntelliJ IDEA
 * @author: Lionel Johnson
 * @contact: https://fairy.host
 * @organization: https://github.com/FairylandFuture
 * @datetime: 2025-08-28 15:51:06 UTC+08:00
 ****************************************************/
package host.fairy.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Map;

/**
 * JWT 工具类
 *
 * @author Lionel Johnson
 */
public class JwtUtils {
    
    /**
     * 生成 JWT Token
     *
     * @param sercret   密钥
     * @param ttlSecond 有效期（秒）
     * @param claims    自定义claims
     * @return JWT Token
     */
    public static String generateToken(String sercret, Long ttlSecond, Map<String, Object> claims) {
        
        long expiration = LocalDateTime.now().plusSeconds(ttlSecond).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        
        JwtBuilder jwtBuilder = Jwts.builder()
                .claims(claims)
                .signWith(Keys.hmacShaKeyFor(sercret.getBytes(StandardCharsets.UTF_8)))
                .expiration(new Date(expiration));
        
        return jwtBuilder.compact();
    }
    
    /**
     * 解析 JWT Token
     *
     * @param token  JWT Token
     * @param secret 密钥
     * @return Claims
     */
    public static Claims parseToken(String token, String secret) {
        return Jwts.parser()
                .verifyWith(Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    
    public static void main(String[] args) {
//        SecretKey secretKey = Jwts.SIG.HS256.key().build();
//        System.out.println(Base64.getEncoder().encodeToString(secretKey.getEncoded()));
        
        String token = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc1NjQ2MTM5Nn0.LT1xnfOMnHf9I1_8ak6ofRE1EIY0eAjvnIcXu41vN2s";
        Claims claims = parseToken(token, "7QXqrqtaWVwOAV0ACT4sDRvmIDXvv6XQqymI/iabs/U=");
        System.out.println(claims.toString());
        Integer id = claims.get("id", Integer.class);
        String string = claims.get("username", String.class);
        
        System.out.println(id);
        System.out.println(string);
    }
}
