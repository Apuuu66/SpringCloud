package com.guier.springboot.validator.dto;

import lombok.Getter;
import lombok.Setter;
import org.apache.http.HttpStatus;

import java.io.Serializable;

@Getter
@Setter
public class RspDTO<T> implements Serializable {
    private T data;
    private Integer code;
    private String msg;

    public RspDTO() {
    }

    public RspDTO(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RspDTO(T data, Integer code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static RspDTO error() {
        return new RspDTO(HttpStatus.SC_INTERNAL_SERVER_ERROR, "系统繁忙,请稍后再试");
    }

    public static RspDTO success() {
        return new RspDTO(HttpStatus.SC_OK, "success");
    }

}
