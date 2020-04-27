package com.guier.zuul.service;

import com.guier.zuul.entity.UserInfo;

public interface UserInfoService {
    UserInfo findUserById(Long id);

    UserInfo findUserByUserName(String username);
}
