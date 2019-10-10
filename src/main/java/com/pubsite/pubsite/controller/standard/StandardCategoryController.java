package com.pubsite.pubsite.controller.standard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StandardCategoryController {
    @RequestMapping("/standard/category")
    public String Category(Model model) {
        model.addAttribute("message", "Category !!!");
        return "standard/standard-category";
    }
}
