package com.pubsite.pubsite.controller.admin;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.*;
import com.pubsite.pubsite.service.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.*;

@Controller
@RequestMapping("/admin/atools")
public class AdminTController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArchiveService archiveService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AutArtService autArtService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private  RequirementsService requirementsService;

    @Autowired
    private EmailRemindService emailRemindService;

    private JavaMailSender mailSender;


    @Autowired
    private AdminTController(UserService userService, ArchiveService archiveService, ArticleService articleService, AutArtService autArtService, RoleService roleService, RequirementsService requirementsService) {
        this.userService = userService;
        this.archiveService = archiveService;
        this.articleService = articleService;
        this.autArtService = autArtService;
        this.roleService = roleService;
        this.requirementsService = requirementsService;

    }

    public Optional<Article> findOne(@PathVariable Integer id) {
        return articleService.findOne(id);
    }

    public void addArticle(@RequestBody Article article) {
        this.articleService.addArticle(article);
    }

    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    public List<Article> articleList() {
        return articleService.articleList();
    }

    public User findOne(@PathVariable String username) {
        return userService.findByUsername(username);
    }

    public List<User> userList() {
        return userService.userList();
    }

    public List<Archive> archiveList() {
        return archiveService.archiveList();
    }

    public List<AutArt> autartList() {
        return Lists.reverse(autArtService.autartList());
    }

    public List<Requirements> requirementsList() {
        return requirementsService.requirementsList();
    }


    @RequestMapping(value = "/articletool", method = RequestMethod.GET)
    public String ATool(Model model) {
        model.addAttribute("autartList", autartList());
        return "admin/admin-atool";
    }

    @RequestMapping(value = "/articletool", params = "article-submit", method = RequestMethod.GET)
    public String ATool(Model model, @RequestParam("title_s") String title, @RequestParam("con_s") String content, @RequestParam("fields") String category, @RequestParam("submit_id") Integer submit_id, RedirectAttributes redir, HttpServletRequest request) {

        User loggedUser = userService.findCurrentLoggedUser();
        Optional<AutArt> autArt = autArtService.findOne(submit_id);
        AutArt setAutArt = autArt.get();

        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        article.setCategory(category);
        article.setAdded(Timestamp.from(Instant.now()));
        article.setAuthors(setAutArt.getAuthors());
        article.setAdmins(loggedUser.getId());

        Optional<User> optional = Optional.ofNullable(userService.findCurrentLoggedUser());

        if (!optional.isPresent()) {
            model.addAttribute("errorMessage", "No account with this e-mail.");
        } else {

            SimpleMailMessage passwordEmail = new SimpleMailMessage();
            passwordEmail.setFrom("pubsite.support@wp.pl");
            passwordEmail.setTo(loggedUser.getEmail());
            passwordEmail.setSubject("Your article has been approved");
            passwordEmail.setText("Hello\n " +
                    "Your article has been successfully proofread\n " +
                    "Please send us some images you want to include with your article when we make whole issue\n " +
                    "Kind regards MyFacultyInfo support team");

            emailRemindService.sendEmail(passwordEmail);
        }

        articleService.addArticle(article);
        autArtService.deleteAutArt(submit_id);

        redir.addFlashAttribute("resultMessage", "Article has been successfully uploaded !");

        return "redirect:/admin/atools/articletool";
    }

    @RequestMapping(value = "/articletool", params = "article-reject", method = RequestMethod.GET)
    public String RTool(@RequestParam("reject_id") Integer reject_id,@RequestParam("why_r") String why_r, RedirectAttributes redir) {


        Optional<AutArt> autArt = autArtService.findOne(reject_id);
        AutArt updateAutArt = autArt.get();
        updateAutArt.setTitle(updateAutArt.getTitle());
        updateAutArt.setContent(updateAutArt.getContent());
        updateAutArt.setWritten(Timestamp.from(Instant.now()));
        updateAutArt.setWhyreject(why_r);
        updateAutArt.setFinished(false);
        updateAutArt.setRejected(true);
        updateAutArt.setAuthors(updateAutArt.getAuthors());

        autArtService.deleteAutArt(reject_id);
        autArtService.addAutArt(updateAutArt);

        redir.addFlashAttribute("resultMessage", "Article has rejected !");

        return "redirect:/admin/atools/articletool";
    }

    @RequestMapping(value = "/userstool", method = RequestMethod.GET)
    public String UTool(Model model) {
        model.addAttribute("userList", userList());
        return "admin/admin-utool";
    }

    @RequestMapping(value = "/userstool", params = "userEnabled", method = RequestMethod.GET)
    public String Change(@RequestParam("userid") Integer userId, Model model) {
        Optional<User> user = userService.findUserById(userId);
        if (user.get().isEnabled()) {
            user.get().setEnabled(false);
        } else {
            user.get().setEnabled(true);
        }
        userService.save(user.get());
        return "redirect:/admin/atools/userstool";
    }

    @RequestMapping(value = "/userstool", params = "roleChange", method = RequestMethod.GET)
    public String RoleChange(@RequestParam("roleid") Integer roleId, Model model) {

        List<GrantedAuthority> authorities = new ArrayList<>();
        if (authorities.equals("author")) {
            authorities.add(new SimpleGrantedAuthority("standard"));
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                            SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                            authorities)
            );
        } else {
            authorities.add(new SimpleGrantedAuthority("author"));
            SecurityContextHolder.getContext().setAuthentication(
                    new UsernamePasswordAuthenticationToken(
                            SecurityContextHolder.getContext().getAuthentication().getPrincipal(),
                            SecurityContextHolder.getContext().getAuthentication().getCredentials(),
                            authorities)
            );
        }

        return "redirect:/admin/atools/userstool";
    }

    @RequestMapping(value = "/issuetool", method = RequestMethod.GET)
    public String ITool(Model model) {
        model.addAttribute("archiveList", archiveList());
        return "admin/admin-itool";
    }

    @RequestMapping(value = "/issuetool", params = "archives", method = RequestMethod.GET)
    public String ITool(@RequestParam("issueName") String issueName, @RequestParam("desc") String desc, @RequestParam("file") File file, Model model, RedirectAttributes redir) throws IOException {

        Archive archive = new Archive();
        archive.setName(issueName);
        archive.setDescription(desc);
        String fileName = "";
        if (!Objects.equals(file, null)) {
            fileName = file.getName();
            archive.setFilename(fileName);
        }
        archive.setContent("C:\\Users\\adria\\Idea\\pubsite\\archives\\" + fileName);
        archive.setContentType(FilenameUtils.getExtension(fileName));
        archiveService.addArchive(archive);
        System.out.println(file.getAbsolutePath());
        File fileToCopy = new File("C:\\Users\\adria\\Downloads\\" + file);
        FileUtils.copyFile(fileToCopy, new File("C:\\Users\\adria\\Idea\\pubsite\\archives\\" + fileName));

        redir.addFlashAttribute("resultMessage", "File has been successfully uploaded !");
        return "redirect:/admin/atools/issuetool";
    }

    @RequestMapping(value = "/requirementstool", method = RequestMethod.GET)
    public String WTool(Model model) {
        model.addAttribute("requirementsList", requirementsList());
        return "admin/admin-wtool";
    }

    @RequestMapping(value = "/requirementstool", params = "requirement-update", method = RequestMethod.GET)
    public String WTool(@RequestParam("requirementid") Integer requirementid,@RequestParam("requirement") String requirement, RedirectAttributes redir) {

        requirementsService.update(requirement, requirementid);

        redir.addFlashAttribute("resultMessage", "Requirements has been updated !");

        return "redirect:/admin/atools/requirementstool";
    }

}