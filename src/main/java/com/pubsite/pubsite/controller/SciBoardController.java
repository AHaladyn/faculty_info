package com.pubsite.pubsite.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SciBoardController {
    @RequestMapping("/sciboard")
    public String SciBoard(Model model) {
        model.addAttribute("message", "SciBoard !!!");
        return "sciboard";
    }

}
