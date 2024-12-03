package com.example.controller;

import com.example.model.po.User;
import com.example.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import com.example.model.DTO.UserDTO;
import com.example.model.VO.ResponseVO;
import com.example.model.VO.UserVO;
import lombok.val;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@RestController
public class HelloController {
    @Autowired
    private IUserService userService;
    @GetMapping("/")
    public String  hello(){
       return "Hello world";
    }
    /**
     * 获取用户列表
     * @return 用户列表
     */
    @GetMapping("/getList")//只能添加在方法上，表示接收get请求（查找请求）
    public ResponseVO getUsers() {
        List<UserVO> response = new ArrayList<UserVO>();
        UserVO user = new UserVO();
        user.setName("张三");
        user.setAge(18);
        response.add(user);
        UserVO user1 = new UserVO();
        user1.setName("李四");
        user1.setAge(19);
        log.info("info级别的日志");
        log.warn("warn级别的日志");
        log.error("error级别的日志");
        log.debug("debug级别的日志");
        response.add(user1);
        return ResponseVO.ok().data("item",response);
    }
    /**
     * 根据名字获取用户
     * @param name 名字
     * @return 用户信息
     */
    @GetMapping("/getUserByName")
    public ResponseVO getUserByName(@RequestParam String name) {
        /**
         * 用于解析URL查询参数，通过http://localhost:8080/api/user/getUserByName?name=John
         */
        UserVO userVO = new UserVO();
        userVO.setName(name);
        userVO.setAge(18);

        return ResponseVO.ok().data("item",userVO);

    }/**
     * 通过id获取用户
     * @param id 用户id
     * @return 用户信息
     */
    @GetMapping("/getUserById/{id}")
    public ResponseVO getUserById(@PathVariable Long id) {
        // @PathVariable 用于接收解析路径参数，http://localhost:8080/api/user/getUserById/123
        UserVO userVO = new UserVO();
        userVO.setId(id);
        userVO.setName("张三");
        userVO.setAge(18);
        return ResponseVO.ok().data("item",userVO);
    }
    /**
     * 根据id和name获取用户
     * @param id 用户id
     * @param name 用户名
     * @return 用户信息
     */
    @GetMapping("/getUserByIdAndName/{id}")
    public ResponseVO getUserByIdAndName(@PathVariable Long id, @RequestParam(required = false) String name) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        if (name != null) {
            userVO.setName(name);
        }else {
            userVO.setName("张三");
        }
        return ResponseVO.ok().data("item",userVO);
    }
    /**
     * 注册用户
     * @param user 用户信息
     */
    @PostMapping("/register")//用于接收保存数据请求
    public ResponseVO save(@RequestBody UserDTO user){
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        //对数据进行保存
        return ResponseVO.ok().data("item",userVO);
    }

    /**
     * 普通保存用户
     * @param user 用户信息
     * @return 响应
     */
    @PostMapping("/save")//用于接收保存数据请求
    public ResponseVO save1(@RequestBody UserDTO user){
        val user1 = new User();
        BeanUtils.copyProperties(user, user1);
        val save = userService.save(user1);
        //对数据进行保存
        return save ? ResponseVO.ok():ResponseVO.error();
    }
    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PutMapping("/updateById")//用于接收更新请求
    public ResponseVO updateById(@RequestBody UserDTO user) {
        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(user, userVO);
        //userService.updateById(user)
        return ResponseVO.ok().data("item",userVO);
    }
    @DeleteMapping("/remove/{id}")
    public ResponseVO removeById(@PathVariable Long id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        //UserService.removeById(id)
        return ResponseVO.ok().data("item",userVO);
    }
}

