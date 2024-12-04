package com.example.service;

import com.example.model.DTO.UserDTO;
import com.example.model.DTO.UserRegisterDTO;
import com.example.model.VO.ResponseVO;
import com.example.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author novel
 * @since 2024-12-03
 */
public interface IUserService extends IService<User> {
    /**
     * 注册的实现
     * @param user
     * @return
     */
    ResponseVO register(UserRegisterDTO user);
}
