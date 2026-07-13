package com.joaomasumoto.workshopmongo.dto;

import com.joaomasumoto.workshopmongo.domain.Post;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class PostDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private String title;
    private String body;

    public PostDTO() {

    }

    public PostDTO(Post obj) {
            id = obj.getId();
            date = obj.getDate();
            title = obj.getTitle();
            body = obj.getBody();
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
