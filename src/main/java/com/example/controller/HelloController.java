package com.example.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.model.DTO.UserLoginDTO;
import com.example.model.DTO.UserRegisterDTO;
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
import java.util.Map;


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
     * 使用id查询用户新版
     * @return 响应
     */
    @GetMapping("/getList2/{id}")
    public ResponseVO getUsers2(@PathVariable Long id) {
        User byId = userService.getById(id);
        return ResponseVO.ok().data("user",byId);
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
     * 注册用户原版
     * @param user 用户信息
     */
    @PostMapping("/register")//用于接收保存数据请求
    public ResponseVO save(@RequestBody UserRegisterDTO user){
       return userService.register(user);
    }
    /**
     * 用户登录
     * @return
     */
    @PostMapping("/login")
    public ResponseVO login(@RequestBody UserLoginDTO userLoginDTO) {
        ResponseVO responseVO = userService.login(userLoginDTO);
        return responseVO;
    }
    /**
     * 普通保存用户新版
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
     * 更新用户信息原版
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

    /**
     * 更新用户的新版
     * @param user 用户的信息
     * @return 响应
     */
    @PutMapping("/updateById2")//用于接收更新请求
    public ResponseVO updateById2(@RequestBody UserDTO user) {
        val user1 = new User();
        BeanUtils.copyProperties(user, user1);
        boolean b = userService.updateById(user1);
        //userService.updateById(user)
        return b ? ResponseVO.ok():ResponseVO.error();
    }

    /**
     * 删除一个用户原版
     * @param id
     * @return
     */

    @DeleteMapping("/remove/{id}")
    public ResponseVO removeById(@PathVariable Long id) {
        UserVO userVO = new UserVO();
        userVO.setId(id);
        //UserService.removeById(id)
        return ResponseVO.ok().data("item",userVO);
    }

    /**
     * 逻辑删除一个用户新版
     * @param id 要删除的用户id
     * @return 响应
     */
    @DeleteMapping("/del/{id}")
    public ResponseVO del(@PathVariable Long id){
        boolean b = userService.removeById(id);
        return b ? ResponseVO.ok():ResponseVO.error();

    }


}

