package com.pubsite.pubsite.controller.author;

import com.pubsite.pubsite.entity.AutArt;
import com.pubsite.pubsite.entity.Requirements;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.AutArtService;
import com.pubsite.pubsite.service.AuthorsService;
import com.pubsite.pubsite.service.RequirementsService;
import com.pubsite.pubsite.service.UserService;
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

@Controller
public class AuthorToolController {

    @Autowired
    private AutArtService autArtService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorsService authorsService;

    @Autowired
    private RequirementsService requirementsService;

    public void addAutArt(AutArt autArt) {
        this.autArtService.addAutArt(autArt);
    }
    public List<Requirements> requirementsList() {
        return requirementsService.requirementsList();
    }

    @RequestMapping(value = "/author/wtool")
    public String Tool(Model model) {
        model.addAttribute("requirementsList", requirementsList());
        return "author/author-wtool";
    }

    @RequestMapping(value = "/author/wtool", params = "autart", method = RequestMethod.GET)
    public String Tool(Model model, @RequestParam("name") String title, @RequestParam("title") String content, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();

        AutArt autArt = new AutArt();
        autArt.setTitle(title);
        autArt.setContent(content);
        autArt.setWritten(Timestamp.from(Instant.now()));
        autArt.setFinished(true);
        autArt.setRejected(false);
        autArt.setWhyreject(null);
        autArt.setAuthors(loggedUser.getId());

        autArtService.addAutArt(autArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully uploaded !");
        return "redirect:/author/wtool";
    }

    @RequestMapping(value = "/author/wtool", params = "saveautart", method = RequestMethod.GET)
    public String SaveTool(Model model, @RequestParam("name") String title, @RequestParam("title") String content, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();

        AutArt autArt = new AutArt();
        autArt.setTitle(title);
        autArt.setContent(content);
        autArt.setWritten(Timestamp.from(Instant.now()));
        autArt.setFinished(false);
        autArt.setRejected(false);
        autArt.setWhyreject(null);
        autArt.setAuthors(loggedUser.getId());

        autArtService.addAutArt(autArt);

        redir.addFlashAttribute("resultMessage", "Article has been successfully saved!");
        return "redirect:/author/myarticle/saved";
    }
}
