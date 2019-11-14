package com.hellow.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "posts")
public class Post {

    @Id
    private Integer id;

    @Column(name = "post_text")
    private String postText;

    @Column(name = "post_name")
    private String postName;

    @Column(name = "post_creator")
    private String postCreator;

    public Post(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }

    public String getPostText() {
        return postText;
    }

    public void setPostName(String postName){this.postName = postName;}

    public String getPostName(){return postName;}

    public void setPostCreator(String postCreator) {
        this.postCreator = postCreator;
    }

    public String getPostCreator() {
        return postCreator;
    }
}
