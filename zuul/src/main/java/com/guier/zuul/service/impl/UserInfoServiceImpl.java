package com.guier.zuul.service.impl;

import com.guier.zuul.entity.UserInfo;
import com.guier.zuul.service.UserInfoService;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Override
    public UserInfo findUserById(Long id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zengxueqi");
        userInfo.setPassword("123456");
        userInfo.setId(1L);
        return userInfo;
    }

    @Override
    public UserInfo findUserByUserName(String username) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername("zhangsan");
        userInfo.setPassword("123456");
        userInfo.setId(1L);
        return userInfo;
    }
}
