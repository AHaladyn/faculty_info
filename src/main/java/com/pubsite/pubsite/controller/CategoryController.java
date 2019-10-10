package com.pubsite.pubsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    @RequestMapping("/category")
    public String Category(Model model) {
        model.addAttribute("message", "Category !!!");
        return "category";
    }
}
