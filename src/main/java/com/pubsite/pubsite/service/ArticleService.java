package com.pubsite.pubsite.service;

import com.pubsite.pubsite.entity.Article;

import java.util.List;
import java.util.Optional;

public interface ArticleService {
    List<Article> articleList();

    Optional<Article> findOne(Integer id);

    Optional<Article> findById(Integer id);

    void addArticle(Article article);

    void deleteArticle(Integer id);

    List<Article> findAllByTitleContainingOrContentContainingOrCategoryContaining(String title, String content, String category);
}
