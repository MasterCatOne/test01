package com.example.utils;

import lombok.Getter;

/**
 * 业务异常
 */
@Getter
public class BusinessException extends RuntimeException {

    //状态码
    private Integer code;


    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public BusinessException(ResponseEnum responseEnum) {
        super(responseEnum.getMessage());
        this.code = responseEnum.getCode();
    }
    public BusinessException(ResponseEnum responseEnum,Throwable cause) {
        super(responseEnum.getMessage(),cause);
        this.code = responseEnum.getCode();
    }
}