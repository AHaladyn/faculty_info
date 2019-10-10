package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.service.SecurityService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class WelcomeController {

    private String message = "Hello World";
    private String description = "First page";

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = {"/welcome"})
    public String welcome(Map<String, Object> map) {

        WelcomeModel model = new WelcomeModel();
        model.setMessage(message);
        model.setDescription("witam: " + securityService.findLoggedInUsername());
        map.put("model", model);
        return "welcome";
    }

    @RequestMapping("/admin/welcome")
    public String adminWelcome(Model model) {
        return "admin/admin-welcome";
    }

    @RequestMapping("/author/welcome")
    public String authorMain(Model model) {
        return "author/author-welcome";
    }

    @RequestMapping("/standard/welcome")
    public String standardMain(Model model) {
        return "standard/standard-welcome";
    }
}
