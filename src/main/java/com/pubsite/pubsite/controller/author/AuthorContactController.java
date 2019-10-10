package com.pubsite.pubsite.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorContactController {
    @RequestMapping("/author/contact")
    public String Contact(Model model) {
        model.addAttribute("message", "Contact !!!");
        return "author/author-contact";
    }

}
