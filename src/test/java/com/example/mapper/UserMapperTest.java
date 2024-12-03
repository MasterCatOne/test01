package com.example.mapper;

import com.example.model.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testAddUser(){
        User user=new User();
        user.setAge(18);
        user.setName("kkk");
        userMapper.insert(user);
        System.out.println("添加成功");
    }

}