package com.hellow.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    private Integer id;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_owner")
    private String commentOwner;

    @Column(name = "post_id")
    private Integer postId;

    public Comment(){

        }

    public void setId(Integer id) {
            this.id = id;
        }

    public Integer getId() {
            return id;
        }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public Integer getPostId() {
        return postId;
    }

    public void setCommentOwner(String commentOwner) {
        this.commentOwner = commentOwner;
    }

    public String getCommentOwner() {
        return commentOwner;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public String getCommentText() {
        return commentText;
    }
}
