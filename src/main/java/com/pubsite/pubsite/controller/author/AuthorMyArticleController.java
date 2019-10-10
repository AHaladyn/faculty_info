package com.pubsite.pubsite.controller.author;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.entity.AutArt;
import com.pubsite.pubsite.service.ArticleService;
import com.pubsite.pubsite.service.AutArtService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AuthorMyArticleController {

    @Autowired
    private AutArtService autArtService;

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    public void addAutArt(AutArt autArt) {
        this.autArtService.addAutArt(autArt);
    }
    public List<Article> articleList() {
        return Lists.reverse(articleService.articleList());
    }

    @RequestMapping(value = "/author/myarticle")
    public String Tool(Model model) {
        model.addAttribute("message", "Tool !!!");
        return "author/author-myarticle";
    }
}
