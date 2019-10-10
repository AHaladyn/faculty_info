package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.entity.Role;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.RoleService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.EntityManager;
import java.util.*;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private EntityManager em;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerUserPage(Model model) {

        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registrationProcess(Model model, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        User userDTO = new User();
        Role standardRole = roleService.findByName("standard");
        Set<Role> mySet = new HashSet<>(Arrays.asList(standardRole));
        mySet.add(roleService.findByName("standard"));
        userDTO.setUsername(requestParams.get("username"));
        userDTO.setEmail(requestParams.get("email"));
        userDTO.setPassword(requestParams.get("password"));
        userDTO.setPasswordConfirm(requestParams.get("password_confirm"));
        userDTO.setEnabled(true);
        //userDTO.setRoles(mySet);
        //userDTO.setRoles(Arrays.asList(standardRole));

        //insert into user (email, enabled, password, password_confirm, reset_token, username) values (?, ?, ?, ?, ?, ?)

        //adding authority(role)
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("standard"));
        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                        SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                        authorities)
        );


        userService.saveReg(userDTO);

        redir.addFlashAttribute("successMessage", "You registered successfully.");

        return "redirect:/login";
    }
}
