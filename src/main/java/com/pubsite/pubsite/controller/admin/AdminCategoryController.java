package com.pubsite.pubsite.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminCategoryController {
    @RequestMapping("/admin/category")
    public String Category(Model model) {
        model.addAttribute("message", "Category !!!");
        return "admin/admin-category";
    }
}
