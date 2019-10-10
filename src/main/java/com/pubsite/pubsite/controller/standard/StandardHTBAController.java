package com.pubsite.pubsite.controller.standard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StandardHTBAController {
    @RequestMapping("/standard/htba")
    public String Archive(Model model) {
        model.addAttribute("message", "HTBA !!!");
        return "standard/standard-htba";
    }
}
