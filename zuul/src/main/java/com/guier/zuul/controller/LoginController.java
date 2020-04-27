package com.guier.zuul.controller;

import com.guier.zuul.entity.UserInfo;
import com.guier.zuul.service.UserInfoService;
import com.guier.zuul.utils.JwtUtils;
import com.guier.zuul.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Resource
    private UserInfoService userInfoService;

    @PostMapping("/login")
    public Result login(@RequestBody UserInfo userInfo) {
        UserInfo userInfo1 = userInfoService.findUserByUserName(userInfo.getUsername());
        if (userInfo1 == null) {
            return Result.error("登录失败,用户不存在");
        } else {
            if (!userInfo1.getPassword().equals(userInfo.getPassword())) {
                return Result.error("登录失败,密码错误");
            } else {
                //生成Token
                String token = JwtUtils.getToken(userInfo1);
                return Result.ok(token);
            }
        }
    }

    @GetMapping("/token")
    public String testToken() {
        return "你已通过验证";
    }

}
