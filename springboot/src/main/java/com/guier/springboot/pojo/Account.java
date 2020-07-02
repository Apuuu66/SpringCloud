package com.guier.springboot.pojo;

import com.guier.springboot.validator.dto.UserDTO;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class Account {
    Integer id;
    String username;
    String password;
    String email;
    String tel;
    List<UserDTO> list;
}
