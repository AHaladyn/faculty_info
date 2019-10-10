package com.pubsite.pubsite.controller.standard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StandardSciBoardController {
    @RequestMapping("/standard/sciboard")
    public String SciBoard(Model model) {
        model.addAttribute("message", "SciBoard !!!");
        return "standard/standard-sciboard";
    }

}
