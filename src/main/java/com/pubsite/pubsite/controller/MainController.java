package com.pubsite.pubsite.controller;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private MainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    public Optional<Article> findOne(@PathVariable Integer id) {
        return articleService.findOne(id);
    }

    public void addArticle(@RequestBody Article article) {
        this.articleService.addArticle(article);
    }

    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    public List<Article> articleList() {
        return Lists.reverse(articleService.articleList());
    }

    @RequestMapping("/")
    public String welcome(Model model) {
        model.addAttribute("articleList", articleList());
        return "main";
    }


}
