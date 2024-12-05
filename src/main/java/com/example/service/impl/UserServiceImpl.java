package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.model.dto.UserLoginDTO;
import com.example.model.dto.UserRegisterDTO;
import com.example.model.vo.PageVO;
import com.example.model.vo.ResponseVO;
import com.example.model.po.User;
import com.example.mapper.UserMapper;
import com.example.query.UserPageQuery;
import com.example.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.utils.BusinessException;
import com.example.utils.JWTUtil;
import com.example.utils.RandomUtils;
import com.example.utils.ResponseEnum;
import org.apache.commons.codec.digest.Md5Crypt;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author novel
 * @since 2024-12-03
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
     @Autowired
     private UserMapper userMapper;
    @Override
    public ResponseVO register(UserRegisterDTO registerDTO) {
        if(registerDTO.getName()==null){
            throw new BusinessException(ResponseEnum.REGISTER_FAIL);
        }
        User user = new User();//new用户一个对象
        BeanUtils.copyProperties(registerDTO, user);//拷贝值
        user.setSecret("$1$" + RandomUtils.getRandomString(6));//随机生成一个盐
        String pwd = Md5Crypt.md5Crypt(registerDTO.getPwd().getBytes(), user.getSecret());//密码+盐 加密处理
        user.setPwd(pwd);//设置密码

        //账号唯一性检查 123456@qq.com
        if (checkUnique(user.getEmail())) {
            userMapper.insert(user);//保存用户信息
            return ResponseVO.ok().message("注册成功");//返回成功
        } else {
            return ResponseVO.setResult(ResponseEnum.USER_REPEAT);//用户已经存在
        }
    }

    @Override
    public ResponseVO login(UserLoginDTO userLoginDTO) {
        List<User> userList = userMapper.selectList(new QueryWrapper<User>().eq("email", userLoginDTO.getEmail()));

        if (userList != null && userList.size() ==1) {
            User user = userList.get(0);//验证通过
            String crypt = Md5Crypt.md5Crypt(userLoginDTO.getPwd().getBytes(), user.getSecret());//对请求过来的密码进行加密
            if (crypt.equals(user.getPwd())) {
                String token = JWTUtil.geneJsonWebToken(user);//生成token
                return ResponseVO.ok().data("token",token);
            }else {
                return ResponseVO.setResult(ResponseEnum.USER_PWD_ERROR);//密码错误
            }
        }else {

            return ResponseVO.setResult(ResponseEnum.ACCOUNT_UNREGISTER);//未注册
        }
    }

    /**
     * 分页查询用户列表
     * @param pageQuery 查询参数
     * @return 分页信息
     */
    @Override
    public ResponseVO queryUserPage(UserPageQuery pageQuery) {
        Page<User> sort = pageQuery.toMpPageDefaultSortByCreateTimeDesc();
        Page<User> page = lambdaQuery().eq(ObjectUtils.isNotEmpty(pageQuery.getAge()),User::getAge, pageQuery.getAge())
                .like(StringUtils.isNotBlank(pageQuery.getEmail()),User::getEmail, pageQuery.getEmail())
                .like(StringUtils.isNotBlank(pageQuery.getName()),User::getName, pageQuery.getName())
                .page(sort);
        PageVO<User> userPageVo = new PageVO<>();
        userPageVo.of(page);
        return ResponseVO.ok().data("items",userPageVo);
    }

    private boolean checkUnique(String email) {
        QueryWrapper queryWrapper = new QueryWrapper<User>().eq("email", email);//创建查询条件
        List<User> list = userMapper.selectList(queryWrapper); //查找数据库中是否有对应的账号
        return list.size() > 0 ? false : true;//大于零返回false否则返回true
    }
}
