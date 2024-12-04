package com.example.mapper;

import com.example.model.po.User;
import lombok.val;
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
//    测试删除用户
    @Test
    public void testDeleteUser(){
        userMapper.deleteById(2);
        System.out.println("删除成功");
    }
//    查询用户
    @Test
    public void testSelectUser(){
        val user = userMapper.selectById(2);
        System.out.println(user);
    }

}