package com.pubsite.pubsite.controller.admin;

import com.pubsite.pubsite.entity.Admins;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.AdminsService;
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
public class AdminProfileController {

    @Autowired
    private AdminsService adminsService;

    @Autowired
    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @RequestMapping(value = "/admin/profile", method = RequestMethod.GET)
    public String adminProfile(Model model) {
        return "admin/admin-profile";
    }

    @RequestMapping(value = "/admin/profile", method = RequestMethod.POST)
    public String process(Model model, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        User user = userService.findByUsername(currentPrincipalName);
        if (!Objects.equals(user, null)) {
            Integer userId = user.getId();
            Admins admins = adminsService.findAdminsByUserId(userId);

            user.setUsername(requestParams.get("username"));
            user.setEmail(requestParams.get("email"));
            user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));
            user.setPasswordConfirm(bCryptPasswordEncoder.encode(requestParams.get("password_confirm")));
            admins.setFirstName(requestParams.get("first_name"));
            admins.setLastName(requestParams.get("last_name"));

            userService.update(user);
            adminsService.update(admins.getFirstName(), admins.getLastName(), admins.getUserId());

            redir.addFlashAttribute("successMessage", "You changed your credentials successfully.");

        } else {
            System.out.println("Sry Null");
        }


        return "redirect:/standard/welcome";
    }
}
