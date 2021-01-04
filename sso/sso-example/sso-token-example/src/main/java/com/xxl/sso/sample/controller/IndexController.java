package com.xxl.sso.sample.controller;

import com.guier.sso.core.conf.Conf;
import com.guier.sso.core.entity.ReturnT;
import com.guier.sso.core.user.XxlSsoUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @RequestMapping("/")
    @ResponseBody
    public ReturnT<XxlSsoUser> index(HttpServletRequest request) {
        XxlSsoUser xxlUser = (XxlSsoUser) request.getAttribute(Conf.SSO_USER);
        return new ReturnT<>(xxlUser);
    }

}