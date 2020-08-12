package com.guier.configclient.bo;

import lombok.Data;

import java.util.Date;
@Data
public class UserBO {
    Integer id;
    String name;
    Integer age;
    Date birthday;
    String address;
}
