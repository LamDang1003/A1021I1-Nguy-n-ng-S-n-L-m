package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "blogs")
public class BlogPrivate {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    private String nameBlog;
    private String content;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BlogPrivate() {
    }

    public BlogPrivate(long id, String nameBlog, String content) {
        this.id = id;
        this.nameBlog = nameBlog;
        this.content = content;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BlogPrivate{" +
                "id=" + id +
                ", nameBlog='" + nameBlog + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
