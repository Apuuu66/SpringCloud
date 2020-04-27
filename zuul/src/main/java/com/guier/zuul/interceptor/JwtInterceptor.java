package com.guier.zuul.interceptor;

import com.alibaba.fastjson.JSON;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.guier.zuul.annotation.Token;
import com.guier.zuul.entity.UserInfo;
import com.guier.zuul.entity.UserToken;
import com.guier.zuul.service.UserInfoService;
import com.guier.zuul.utils.BnException;
import com.guier.zuul.utils.JwtUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class JwtInterceptor implements HandlerInterceptor {

    @Resource
    UserInfoService userService;

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) {
        final String authorization = "Authorization";
        String token = httpServletRequest.getHeader(authorization);
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(Token.class)) {
            Token passToken = method.getAnnotation(Token.class);
            if (passToken.required()) {
                return true;
            }
        }
        // 执行认证
        if (token == null) {
            BnException.of("无token，请重新登录");
        }
        // 获取 token 中的 user id
        String userId = null;
        try {
            //userId = JWT.decode(token).getAudience().get(0);
            String userJson = JwtUtils.decodeToken(token);
            UserToken userToken = JSON.parseObject(userJson, UserToken.class);
            userId = userToken.getId().toString();
        } catch (JWTDecodeException j) {
            BnException.of("401");
        }
        UserInfo user = userService.findUserById(Long.valueOf(userId));
        if (user == null) {
            BnException.of("用户不存在，请重新登录");
        }
        // 验证 token
        JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
        try {
            String jwtStr = token.replace("Bearer ", "").trim();
            jwtVerifier.verify(jwtStr);
        } catch (JWTVerificationException e) {
            BnException.of("401");
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) {
    }
}
