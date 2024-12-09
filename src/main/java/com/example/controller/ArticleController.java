package com.example.controller;

import com.example.model.po.Article;
import com.example.model.vo.ResponseVO;
import com.example.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * xx管理系统/文章模块
 * @author wangyu
 * @date 2022/11/29 15:06
 */
@CrossOrigin
@RestController
@RequestMapping("/api/article")
public class ArticleController {
    @Autowired
    private IArticleService articleService;
    /**
     * 获取文章列表
     */
    @RequestMapping("/getArticleList")
    public ResponseVO getArticleList() {

        return articleService.getUserList();
    }
    /**
     * 更新文章
     */
    @PutMapping("/updateArticle")
    public ResponseVO updateArticle(@RequestBody Article article) {
        boolean b = articleService.updateById(article);
        return b ? ResponseVO.ok() : ResponseVO.error();
    }
    /**
     * 删除文章
     */
    @DeleteMapping("/remove/{id}")
    public ResponseVO removeArticle(@PathVariable String id) {
        boolean b = articleService.removeById(id);
        return b ? ResponseVO.ok() : ResponseVO.error();
    }
    /**
     * 添加文章
     */
    @PostMapping("/save")
    public ResponseVO saveArticle(@RequestBody Article article) {
        boolean b = articleService.save(article);
        return b ? ResponseVO.ok() : ResponseVO.error();
    }
}
