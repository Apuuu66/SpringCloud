package com.guier.zuul.utils;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.guier.zuul.entity.UserInfo;

import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private static final String TOKEN_STR = "token";
    private static final String SIGNAL_HEAD = "Bearer";

    public static String getToken(UserInfo user) {
        Map<String,String> map = new HashMap<>();
        map.put("id",user.getId().toString());
        map.put("username",user.getUsername());
        String token="";
        token= JWT.create().withAudience(JSON.toJSONString(map))
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

    public static String decodeToken(String token) {
        String jwtStr = token.replace(SIGNAL_HEAD, "").trim();
        DecodedJWT decodedJWT = JWT.decode(jwtStr);
        Map<String, Claim> claims = decodedJWT.getClaims();
        if (decodedJWT == null) {
            throw new BnException(-1000, "加密解析失败");
        }
        Claim claim = decodedJWT.getClaims().get(TOKEN_STR);
        if (claims == null) {
            throw new BnException(-1000, "加密解析失败");
        }
        return claims.get("aud").asString();
    }
}
