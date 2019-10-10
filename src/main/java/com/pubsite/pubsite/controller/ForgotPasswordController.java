package com.pubsite.pubsite.controller;

import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.EmailRemindService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Controller
public class ForgotPasswordController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailRemindService emailRemindService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private JavaMailSender mailSender;

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.GET)
    public String displayForgotPasswordPage(Model model) {
        return "forgotPassword";
    }

    @RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
    public String processForgotPasswordForm(Model model, @RequestParam("email") String userEmail, HttpServletRequest request) {

        Optional<User> optional = userService.findUserByEmail(userEmail);

        if (!optional.isPresent()) {
            model.addAttribute("errorMessage", "No account with this e-mail.");
        } else {

            User user = optional.get();
            user.setResetToken(UUID.randomUUID().toString());
            userService.save(user);
            String appUrl = request.getScheme() + "://" + request.getServerName();

            SimpleMailMessage passwordEmail = new SimpleMailMessage();
            passwordEmail.setFrom("pubsite.support@wp.pl");
            passwordEmail.setTo(user.getEmail());
            passwordEmail.setSubject("Password reminder service");
            passwordEmail.setText("To reset your password click here:\n" + appUrl
                    + ":8888/resetPassword?token=" + user.getResetToken());

            emailRemindService.sendEmail(passwordEmail);
            model.addAttribute("successMessage", "Password reset link was sent to: " + userEmail);
        }
        return "forgotPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.GET)
    public String displayResetPasswordPage(Model model, @RequestParam("token") String token) {

        Optional<User> user = userService.findUserByResetToken(token);

        if (user.isPresent()) {
            model.addAttribute("resetToken", token);
        } else {
            model.addAttribute("errorMessage", "Oops!  Password resetting link is not active or wrong.");
        }

        return "resetPassword";
    }

    @RequestMapping(value = "/resetPassword", method = RequestMethod.POST)
    public String setNewPassword(Model model, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {

        Optional<User> user = userService.findUserByResetToken(requestParams.get("token"));

        if (user.isPresent()) {

            User resetUser = user.get();

            resetUser.setPassword(requestParams.get("password"));
            resetUser.setPasswordConfirm(requestParams.get("password_confirm"));
            resetUser.setResetToken(null);

            userService.save(resetUser);

            redir.addFlashAttribute("successMessage", "Your password was successfully changed, you may log in now.");

            return "redirect:/login";

        } else {
            model.addAttribute("errorMessage", "Oops!  Password resetting link is expired or wrong.");
        }

        return "resetPassword";
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingParams(MissingServletRequestParameterException ex) {
        return ("redirect:/login");
    }

}
