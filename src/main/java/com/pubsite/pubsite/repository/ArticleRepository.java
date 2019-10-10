package com.pubsite.pubsite.repository;

import com.pubsite.pubsite.entity.Article;
import org.checkerframework.checker.units.qual.A;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findAllByTitleContainingOrContentContainingOrCategoryContaining(String title, String content, String category);
    Optional<Article> findById(Integer id);
}
