package com.pubsite.pubsite.controller.author;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.entity.AutArt;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/author/myarticle")
public class AuthorMArtController {

    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AutArtService autArtService;

    @Autowired
    private AuthorMArtController(UserService userService, ArticleService articleService, AutArtService autArtService) {
        this.userService = userService;
        this.articleService = articleService;
        this.autArtService = autArtService;

    }

    public void addAutArt(AutArt autArt) {
        this.autArtService.addAutArt(autArt);
    }
    public List<Article> articleList() {
        return Lists.reverse(articleService.articleList());
    }
    public List<AutArt> autartList() {
        return Lists.reverse(autArtService.autartList());
    }

    @RequestMapping(value = "/finished")
    public String FTool(Model model) {
        User loggedUser = userService.findCurrentLoggedUser();
        model.addAttribute("articleList", articleList());
        model.addAttribute("loggedUser", loggedUser);
        return "author/author-ma-finished";
    }

    @RequestMapping(value = "/saved")
    public String STool(Model model) {
        model.addAttribute("autartList", autartList());
        return "author/author-ma-saved";
    }

    @RequestMapping(value = "/rejected")
    public String RTool(Model model) {
        model.addAttribute("autartList", autartList());
        return "author/author-ma-rejected";
    }

    @RequestMapping(value = "/saved", params = "article-submit", method = RequestMethod.GET)
    public String SATool(Model model, @RequestParam("title_s") String title, @RequestParam("con_s") String content, @RequestParam("submit_id") Integer submit_id, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();
        Optional<AutArt> autArt = autArtService.findOne(submit_id);
        AutArt updateAutArt = autArt.get();
        updateAutArt.setTitle(title);
        updateAutArt.setContent(content);
        updateAutArt.setWritten(Timestamp.from(Instant.now()));
        updateAutArt.setFinished(true);
        updateAutArt.setRejected(false);
        updateAutArt.setWhyreject(null);
        updateAutArt.setAuthors(loggedUser.getId());

        autArtService.deleteAutArt(submit_id);
        autArtService.addAutArt(updateAutArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully uploaded !");

        return "redirect:/author/myarticle/saved";
    }


    @RequestMapping(value = "/saved", params = "article-save", method = RequestMethod.GET)
    public String SSTool(Model model, @RequestParam("title_s") String title, @RequestParam("con_s") String content, @RequestParam("save_id") Integer save_id, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();
        Optional<AutArt> autArt = autArtService.findOne(save_id);
        AutArt updateAutArt = autArt.get();
        updateAutArt.setTitle(title);
        updateAutArt.setContent(content);
        updateAutArt.setWritten(Timestamp.from(Instant.now()));
        updateAutArt.setFinished(false);
        updateAutArt.setRejected(false);
        updateAutArt.setWhyreject(null);
        updateAutArt.setAuthors(loggedUser.getId());

        autArtService.deleteAutArt(save_id);
        autArtService.addAutArt(updateAutArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully saved !");

        return "redirect:/author/myarticle/saved";
    }

    @RequestMapping(value = "/rejected", params = "article-submit", method = RequestMethod.GET)
    public String RATool(Model model, @RequestParam("title_s") String title, @RequestParam("con_s") String content, @RequestParam("submit_id") Integer submit_id, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();
        Optional<AutArt> autArt = autArtService.findOne(submit_id);
        AutArt updateAutArt = autArt.get();
        updateAutArt.setTitle(title);
        updateAutArt.setContent(content);
        updateAutArt.setWritten(Timestamp.from(Instant.now()));
        updateAutArt.setFinished(true);
        updateAutArt.setRejected(false);
        updateAutArt.setWhyreject(null);
        updateAutArt.setAuthors(loggedUser.getId());

        autArtService.deleteAutArt(submit_id);
        autArtService.addAutArt(updateAutArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully uploaded !");

        return "redirect:/author/myarticle/rejected";
    }


    @RequestMapping(value = "/rejected", params = "article-save", method = RequestMethod.GET)
    public String RSTool(Model model, @RequestParam("title_s") String title, @RequestParam("con_s") String content, @RequestParam("save_id") Integer save_id, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();
        Optional<AutArt> autArt = autArtService.findOne(save_id);
        AutArt updateAutArt = autArt.get();
        updateAutArt.setTitle(title);
        updateAutArt.setContent(content);
        updateAutArt.setWritten(Timestamp.from(Instant.now()));
        updateAutArt.setFinished(false);
        updateAutArt.setRejected(false);
        updateAutArt.setWhyreject(null);
        updateAutArt.setAuthors(loggedUser.getId());

        autArtService.deleteAutArt(save_id);
        autArtService.addAutArt(updateAutArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully saved !");

        return "redirect:/author/myarticle/rejected";
    }


}
