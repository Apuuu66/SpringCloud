package com.guier.sso.server.service;


import com.guier.sso.server.core.model.UserInfo;
import com.guier.sso.server.core.result.ReturnT;

public interface UserService {

    public ReturnT<UserInfo> findUser(String username, String password);

}
