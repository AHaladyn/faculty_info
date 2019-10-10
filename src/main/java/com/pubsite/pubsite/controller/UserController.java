package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.service.ArticleService;
import com.pubsite.pubsite.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userRole = authentication.getAuthorities().toString();
        boolean isLoggedIn = false;
        if (!userRole.equals("[ROLE_ANONYMOUS]"))
            isLoggedIn = true;

        if (isLoggedIn) {
            userRole = userRole.substring(1, userRole.length() - 1);
            return "redirect:/" + userRole + "/welcome";
        }

        if (error != null)
            model.addAttribute("error", "Incorrect username or password or your account has been deactivated.");

        if (logout != null)
            model.addAttribute("message", "You logged out successfully.");

        return "login";
    }
}
