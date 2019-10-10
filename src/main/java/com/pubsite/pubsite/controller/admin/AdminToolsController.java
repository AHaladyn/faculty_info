package com.pubsite.pubsite.controller.admin;

import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminToolsController {

    @Autowired
    private UserService userService;

    @Autowired
    private AdminToolsController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping("/admin/atools")
    public String Tool(Model model) {
        model.addAttribute("message", "Tools !!!");
        return "admin/admin-tools";
    }
}
