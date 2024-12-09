package com.example.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @since 2024-12-06
 */
@Getter
@Setter
@TableName("article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 新闻标题
     */
    @TableField("title")
    private String title;

    /**
     * 新闻的内容
     */
    @TableField("content")
    private String content;

    /**
     * 作者
     */
    @TableField("author")
    private String author;

    /**
     * 创建时间	
     */
    @TableField("create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间	
     */
    @TableField("update_time")
    private LocalDateTime updateTime;

    /**
     * 逻辑删除字段	
     */
    @TableField("is_deleted")
    private Byte isDeleted;
}
