package org.example.POJO.DTO;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}