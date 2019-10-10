package com.pubsite.pubsite.controller.author;

import com.pubsite.pubsite.entity.Authors;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.AuthorsService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Map;
import java.util.Objects;

@Controller
public class AuthorProfileController {

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping(value = "/author/profile", method = RequestMethod.GET)
    public String authorProfile(Model model) {
        return "author/author-profile";
    }

    @RequestMapping(value = "/author/profile", method = RequestMethod.POST)
    public String process(Model model, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findByUsername(currentPrincipalName);
        if (!Objects.equals(user, null)) {
            Integer userId = user.getId();
            Authors authors = authorsService.findAuthorsByUserId(userId);

            user.setUsername(requestParams.get("username"));
            user.setEmail(requestParams.get("email"));
            user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
            user.setPasswordConfirm(bCryptPasswordEncoder.encode(requestParams.get("password_confirm")));
            authors.setFirstName(requestParams.get("first_name"));
            authors.setLastName(requestParams.get("last_name"));

            userService.update(user);
            authorsService.update(authors.getFirstName(), authors.getLastName(), authors.getUserId());

            redir.addFlashAttribute("successMessage", "You changed your credentials successfully.");
        } else {
            System.out.println("Sry Null");
        }


        return "redirect:/author/welcome";
    }
}
