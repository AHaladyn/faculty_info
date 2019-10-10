package com.pubsite.pubsite.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorCategoryController {
    @RequestMapping("/author/category")
    public String Category(Model model) {
        model.addAttribute("message", "Category !!!");
        return "author/author-category";
    }
}
