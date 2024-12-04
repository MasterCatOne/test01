package com.example.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {
   
    /**
     * 昵称
     */
    private String name;
   
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 密码
     */
    private String pwd;
   
    /**
     * 电子邮箱
     */
    private String email;
   
    /**
     * 0表示女，1表示男
     */
    private Integer sex;   
}