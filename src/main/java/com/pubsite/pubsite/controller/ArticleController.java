package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //@RequestMapping("/list/{id}")
    public Optional<Article> findOne(@PathVariable Integer id) {
        return articleService.findOne(id);
    }

    //@RequestMapping("/add")
    public void addArticle(@RequestBody Article article) {
        this.articleService.addArticle(article);
    }

    //@RequestMapping("/delete/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    @RequestMapping("/list")
    public List<Article> articleList() {
        return articleService.articleList();
    }

    @RequestMapping(value="/list/{id}", method=RequestMethod.GET)
    public String welcome(Model model, @PathVariable Integer id) {

        model.addAttribute("articleList", articleList());
        model.addAttribute("article_id", id);
        return "article";
    }

}
