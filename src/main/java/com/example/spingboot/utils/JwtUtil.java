package com.example.spingboot.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author abbas
 * @description: Json web token 工具类
 * @date 2022/5/14 14:16
 */

@Component
@Data
@ConfigurationProperties(prefix = "jwt")
public class JwtUtil {

        static final String USER_NAME = "username";
        static final String TOKEN_SUB = "uuid";
        private String secret;          //密码
        private Long validity;        //有效期

        public String generateTaken(String username){
                //header
                Map<String,Object> header = new HashMap<>();
                header.put("alg","HS256");
                header.put("typ","JWT");
                //签发时间
                long created = System.currentTimeMillis();
                Date issued = new Date(created);
                //过期时间
                long expires  =created + validity;
                Date expiration = new Date(expires);
                //私有声明
                Map<String,Object> cliams = new HashMap<>();
                cliams.put(TOKEN_SUB, UUID.randomUUID());
                cliams.put(USER_NAME,username);

                return Jwts.builder()
                        .setHeader(header)
                        .setClaims(cliams)
                        .setIssuedAt(issued)
                        .setExpiration(expiration)
                        .signWith(SignatureAlgorithm.HS256,secret)
                        .compact();
        }

        public Claims parseToken(String token){
                Claims claims = Jwts.parser()
                        .setSigningKey(secret)
                        .parseClaimsJws(token)
                        .getBody();
                return claims;
        }

        /**
         * token是否过期
         * @param token 令牌
         * @return token是否过期
         */
        public boolean isExpires(String token){
                if (token == null) return true;

                try {
                        //若token过期，解析token将会引发异常
                        Claims claims = parseToken(token);
                } catch (Exception e) {
                        return true;
                }

                return false;
        }

        public String getUsername(String token){
                Claims claims = null;
                try {
                        claims = parseToken(token);
                } catch (Exception e) {
                        return "token过期";
                }
                return (String) claims.get(USER_NAME);
        }

        /**
         * 判断客户端token与redis当中token是否相等，相等则token有效
         * @param accessToken 客户点请求的token
         * @param validityToke redis缓存当中的token
         * @return token是否有效
         */
        public boolean validityToken(String accessToken,String validityToke){
                if (validityToke != null) {
                        if (accessToken.equals(validityToke)) {
                                return true;
                        }
                }
                return false;
        }

}
