package com.guier.configclient.service;

import com.guier.configclient.pojo.User;

import java.util.List;

public interface UserService {
    List<User> page(Integer page, Integer size, User user);
}
