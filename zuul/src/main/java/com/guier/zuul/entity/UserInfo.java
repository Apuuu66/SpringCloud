package com.guier.zuul.entity;

import lombok.Data;

@Data
public class UserInfo {

    /**
     * 用户id
     */
    private Long id;
    /**
     * 姓名
     */
    private String username;
    /**
     * 密码
     * @ingore
     */
    private String password;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 手机号
     */
    private String mobile;

}
