package com.pubsite.pubsite.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(PATH)
    public String error(Model model, Authentication authentication) {
        model.addAttribute("message", "Error !!!");

//        boolean isUser = false;
//        boolean isAdmin = false;
//        boolean isAuthor = false;
//
//        Collection<? extends GrantedAuthority> authorities
//                = authentication.getAuthorities();

//        for (GrantedAuthority grantedAuthority : authorities) {
//            if (grantedAuthority.getAuthority().equals("standard")) {
//                isUser = true;
//                break;
//            } else if (grantedAuthority.getAuthority().equals("admin")) {
//                isAdmin = true;
//                System.out.println(authentication.getAuthorities());
//                break;
//            } else if (grantedAuthority.getAuthority().equals("author")) {
//                isAuthor = true;
//                break;
//            }
//        }
//        System.out.println(authentication.getAuthorities());
//        if (authentication.getAuthorities().toString() == "[admin]") {
//            return "admin-index";
//        } else if (authentication.getAuthorities().equals("[author]")) {
//            return "author-index";
//        }else if (authentication.getAuthorities().equals("[standard]")) {
//            return "standard-index";
//        }else {
            return "index";
        //}
    }

}
