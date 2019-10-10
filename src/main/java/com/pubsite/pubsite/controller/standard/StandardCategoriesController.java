package com.pubsite.pubsite.controller.standard;

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
@RequestMapping("/standard/category")
public class StandardCategoriesController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private StandardCategoriesController(ArticleService articleService) {
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


    @RequestMapping("/entertainment")
    public String Entertainment(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-entertainment";
    }

    @RequestMapping("/faculty")
    public String Faculty(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-faculty";
    }

    @RequestMapping("/science")
    public String Science(Model model) {
        model.addAttribute("message", "Science !!!");
        return "standard/standard-science";
    }

    @RequestMapping("/science/cs")
    public String ScienceCS(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-science-cs";
    }

    @RequestMapping("/science/ee")
    public String ScienceEE(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-science-ee";
    }

    @RequestMapping("/science/et")
    public String ScienceET(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-science-et";
    }

    @RequestMapping("/sport")
    public String Sport(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-sport";
    }

    @RequestMapping("/uncategorized")
    public String Uncategorized(Model model) {
        model.addAttribute("articleList", articleList());
        return "standard/standard-uncategorized";
    }
}

