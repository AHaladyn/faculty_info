package com.pubsite.pubsite.entity;


import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "autart")
public class AutArt implements Serializable {

    private static final long serialVersionUID = -2693254862740520847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    //@Field
    @Column(name = "title")
    @NotNull
    private String title;

    //@Field
    @Column(name = "content")
    @NotNull
    private String content;

    //@Field
    @Column(name = "written")
    @NotNull
    private Timestamp written;

    @Column(name = "finished")
    @NotNull
    private boolean finished;

    @Column(name = "rejected")
    @NotNull
    private boolean rejected;

    @Column(name = "whyreject")
    private String whyreject;

    //    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "author_id")
    @Column(name = "author_id")
    private Integer author_id;

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

    public Timestamp getWritten() {
        return written;
    }

    public void setWritten(Timestamp added) {
        this.written = added;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isRejected() {
        return rejected;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public String getWhyreject() {
        return whyreject;
    }

    public void setWhyreject(String whyreject) {
        this.whyreject = whyreject;
    }

    public Integer getAuthors() {
        return author_id;
    }

    public void setAuthors(Integer author_id) {
        this.author_id = author_id;
    }

}
