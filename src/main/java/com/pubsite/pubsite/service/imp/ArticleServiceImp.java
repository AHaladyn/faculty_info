package com.pubsite.pubsite.service.imp;

import com.pubsite.pubsite.entity.Article;
import com.pubsite.pubsite.repository.ArticleRepository;
import com.pubsite.pubsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("articleService")
//@Transactional
public class ArticleServiceImp implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticleServiceImp(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> articleList() {
        return articleRepository.findAll();
    }

    @Override
    public Optional<Article> findOne(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public Optional<Article> findById(Integer id) {
        return articleRepository.findById(id);
    }

    @Override
    public void addArticle(Article article) {
        this.articleRepository.save(article);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleRepository.deleteById(id);
        System.out.println("{'message':'Article deleted'}");
    }

    @Override
    public List<Article> findAllByTitleContainingOrContentContainingOrCategoryContaining(String title, String content, String category) {
        return articleRepository.findAllByTitleContainingOrContentContainingOrCategoryContaining(title, content, category);
    }
}
