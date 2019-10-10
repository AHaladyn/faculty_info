package com.pubsite.pubsite.controller.admin;

import com.google.common.collect.Lists;
import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.service.ArticleService;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class AdminMainController {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private AdminMainController(ArticleService articleService) {
        this.articleService = articleService;
    }

    public List<Article> articleList() {
        return Lists.reverse(articleService.articleList());
    }

    @RequestMapping("/admin")
    public String main(Model model) {
        model.addAttribute("articleList", articleList());
        return "admin/admin-main";
    }

    @RequestMapping(value = "/admin", params = "articles", method = RequestMethod.GET)
    public String getSelectedArticles(Model model, @RequestParam("art_id") List<Integer> selected) throws IOException {
        List<Integer> listOfArticles = new ArrayList<>();
        if (!Objects.equals(selected, null))
            listOfArticles = selected;

        List<Article> articles = new ArrayList<>();
        for (Integer i : listOfArticles)
            articles.add(articleService.findById(i).get());

        XWPFDocument document = new XWPFDocument();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date date = new Date();
        FileOutputStream outputStream = new FileOutputStream(new File("C:\\Users\\adria\\Idea\\pubsite\\articles\\" + formatter.format(date)) + ".docx");

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        for (Article a : articles) {
            run.setText((Jsoup.parse(a.getTitle()).text()) + "\n\n" + (Jsoup.parse(a.getContent()).text()) + "\n\n" + (Jsoup.parse(a.getCategory()).text()) +"\n\n");
            run.addBreak();
        }
        document.write(outputStream);
        outputStream.close();

        model.addAttribute("success", "Your articles has been downloaded !");
        return "admin/admin-main";
    }
}
