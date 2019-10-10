package com.pubsite.pubsite.controller.author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorSciBoardController {
    @RequestMapping("/author/sciboard")
    public String SciBoard(Model model) {
        model.addAttribute("message", "SciBoard !!!");
        return "author/author-sciboard";
    }

}
