package com.example.model.po;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author novel
 * @since 2024-12-03
 */
@Getter
@Setter
@TableName("user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 昵称
     */
    @TableField("name")
    private String name;

    /**
     * 年龄
     */
    @TableField("age")
    private Integer age;

    /**
     * 密码
     */
    @TableField("pwd")
    private String pwd;

    /**
     * 邮箱
     */
    @TableField("email")
    private String email;

    /**
     * 0表示女，1表示男
     */
    @TableField("sex")
    private Byte sex;

    /**
     * 头像
     */
    @TableField("avatar")
    private String avatar;

    /**
     * 盐，用于个人敏感信息处理
     */
    @TableField("secret")
    private String secret;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 跟新时间
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 删除标记（1:不可用 0:可用）
     */
    //逻辑删除注解
    @TableLogic
    @TableField("is_deleted")
    private Byte isDeleted;
}
