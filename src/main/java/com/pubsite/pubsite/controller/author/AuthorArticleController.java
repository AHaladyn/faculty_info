package com.pubsite.pubsite.controller.author;

import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.entity.Comments;
import com.pubsite.pubsite.entity.User;
import com.pubsite.pubsite.service.ArticleService;
import com.pubsite.pubsite.service.CommentsService;
import com.pubsite.pubsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/author/article")
public class AuthorArticleController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentsService commentsService;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    //@RequestMapping("/list/{id}")
    public Optional<Article> findOne(@PathVariable Integer id) {
        return articleService.findOne(id);
    }

    //@RequestMapping("/add")
    public void addArticle(@RequestBody Article article) {
        this.articleService.addArticle(article);
    }

    //@RequestMapping("/delete/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    //@RequestMapping("/list")
    public List<Article> articleList() {
        return articleService.articleList();
    }
    public List<Comments> commentsList() {
        return commentsService.commentsList();
    }

    @RequestMapping(value="/list/{id}", method= RequestMethod.GET)
    public String welcome(Model model, @PathVariable Integer id) {

        model.addAttribute("articleList", articleList());
        model.addAttribute("article_id", id);
        model.addAttribute("commentsList", commentsList());
        return "author/author-article";
    }

    @RequestMapping(value = "/list/{id}", params = "submit_comment", method = RequestMethod.GET)
    public String Tool(Model model, @PathVariable Integer id, @RequestParam("comment_text") String comment, RedirectAttributes redir) {

        User loggedUser = userService.findCurrentLoggedUser();

        Comments comments = new Comments();
        comments.setContent(comment);
        comments.setArticle_id(id);
        comments.setAuthor_name(loggedUser.getUsername());

        commentsService.addComment(comments);

        redir.addFlashAttribute("resultMessage", "Thank you for your comment!");
        return "redirect:/author/article/list/{id}";
    }

}
