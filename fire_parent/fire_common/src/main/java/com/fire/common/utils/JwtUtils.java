package com.fire.common.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Date;
import java.util.Map;

@Getter
@Setter
@ConfigurationProperties("jwt.config")
public class JwtUtils {
    //签名私钥
    private String key = "fire_king_application";
    //签名的失效时间
    private Long ttl=60*60*1000L;

    /**
     * 设置认证token
     *      id:登录用户id
     *      subject：登录用户名
     *
     */
    public String createJwt(String id, String name, Map<String,Object> map) {
        //1.设置失效时间
        long now = System.currentTimeMillis();//当前毫秒
        long exp = now + ttl;
        //2.创建jwtBuilder
        JwtBuilder jwtBuilder = Jwts.builder().setId(id).setSubject(name)
                //令牌签发时间
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key);
        //3.根据map设置claims
        for(Map.Entry<String,Object> entry : map.entrySet()) {
            jwtBuilder.claim(entry.getKey(),entry.getValue());
        }
        //过期时间需要大于签发时间，过期后，再次访问令牌就会抛出异常
        jwtBuilder.setExpiration(new Date(exp));
        //4.创建token
        return jwtBuilder.compact();

    }


    /**
     * 解析token字符串获取clamis
     */
    public Claims parseJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims;
    }

}
