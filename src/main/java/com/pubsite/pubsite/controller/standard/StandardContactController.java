package com.pubsite.pubsite.controller.standard;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StandardContactController {
    @RequestMapping("/standard/contact")
    public String Contact(Model model) {
        model.addAttribute("message", "Contact !!!");
        return "standard/standard-contact";
    }

}
