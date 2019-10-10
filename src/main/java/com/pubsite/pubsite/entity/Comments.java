package com.pubsite.pubsite.entity;

import org.hibernate.search.annotations.Field;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "comments")
public class Comments {

    private static final long serialVersionUID = -2693254862740520847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Field
    @Column(name = "content")
    @NotNull
    private String content;

    @Column(name = "author_name")
    private String author_name;

    @Column(name = "article_id")
    private Integer article_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public Integer getArticle_id() {
        return article_id;
    }

    public void setArticle_id(Integer article_id) {
        this.article_id = article_id;
    }
}
