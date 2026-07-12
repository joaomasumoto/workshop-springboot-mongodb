package com.joaomasumoto.workshopmongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Document(collection = "post")
public class Post implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;


    @Id
    private String id;
    private Date date;
    private String title;
    private String boty;
    private User author;

    public Post() {

    }

    public Post(String id, Date date, String title, String boty, User author) {
        this.id = id;
        this.date = date;
        this.title = title;
        this.boty = boty;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBoty() {
        return boty;
    }

    public void setBoty(String boty) {
        this.boty = boty;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
