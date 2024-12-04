package com.example.model.DTO;

import lombok.Data;

@Data
public class UserLoginDTO {
    /**
     * 邮箱
     */
    private String email;
   
    /**
     * 密码
     */
    private String pwd;
}