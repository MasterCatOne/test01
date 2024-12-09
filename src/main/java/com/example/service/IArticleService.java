package com.example.service;

import com.example.model.po.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.model.vo.ResponseVO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author novel
 * @since 2024-12-06
 */
public interface IArticleService extends IService<Article> {

    ResponseVO getUserList();
}
