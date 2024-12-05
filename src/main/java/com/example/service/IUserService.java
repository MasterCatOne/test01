package com.example.service;

import com.example.model.dto.UserLoginDTO;
import com.example.model.dto.UserRegisterDTO;
import com.example.model.vo.ResponseVO;
import com.example.model.po.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.query.UserPageQuery;

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
     * 注册方法
     * @param user
     * @return
     */
    ResponseVO register(UserRegisterDTO user);

    /**
     *登录方法
     * @param userLoginDTO 登录信息
     * @return json数据对象
     */
    ResponseVO login(UserLoginDTO userLoginDTO);

    /**
     * 分页请求方法
     * @param pageQuery
     * @return 响应信息
     */
    ResponseVO queryUserPage(UserPageQuery pageQuery);
}
