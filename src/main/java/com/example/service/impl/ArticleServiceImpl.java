package com.example.service.impl;

import com.example.handler.LoginInterceptor;
import com.example.model.bo.LoginUserBO;
import com.example.model.po.Article;
import com.example.mapper.ArticleMapper;
import com.example.model.vo.ResponseVO;
import com.example.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.val;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author novel
 * @since 2024-12-06
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Override
    public ResponseVO getUserList() {
        LoginUserBO loginUserBO = LoginInterceptor.threadLocal.get();
        if(StringUtils.equals(loginUserBO.getEmail(),"111@qq.com")){
            return ResponseVO.error().message("你已经被拉黑");
        }
        List<Article> articles = articleMapper.selectList(null);
        return ResponseVO.ok().data("item",articles);
    }
}
