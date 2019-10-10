package com.pubsite.pubsite.entity;


import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "article")
public class Article implements Serializable {

    private static final long serialVersionUID = -2693254862740520847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Field
    @Column(name = "title")
    @NotNull
    private String title;

    @Field
    @Column(name = "content")
    @NotNull
    private String content;

    @Field
    @Column(name = "category")
    @NotNull
    private String category;

    @Field
    @Column(name = "added")
    @NotNull
    private Timestamp added;

    //    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
    @Column(name = "author_id")
    private Integer authors;

    //    @ManyToOne (fetch = FetchType.LAZY)
//    @JoinColumn(name="proofreader_id")
    @Column(name = "proofreader_id")
    private Integer admins;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Timestamp getAdded() {
        return added;
    }

    public void setAdded(Timestamp added) {
        this.added = added;
    }

    public Integer getAuthors() {
        return authors;
    }

    public void setAuthors(Integer authors) {
        this.authors = authors;
    }

    public Integer getAdmins() {
        return admins;
    }

    public void setAdmins(Integer admins) {
        this.admins = admins;
    }
}
