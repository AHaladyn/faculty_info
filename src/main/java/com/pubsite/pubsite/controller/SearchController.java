package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SearchController {

    @Autowired
    private ArticleRepository articleRepository;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String search(@RequestParam("s") String text, Model model) {
        List<Article> articles = articleRepository.findAllByTitleContainingOrContentContainingOrCategoryContaining(text, text, text);
        model.addAttribute("searchResults", articles);
        return "search";

    }

}
