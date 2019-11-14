package com.hellow.service;

import com.hellow.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(Comment comment);
    Comment getComment(Integer commentId);
    List<Comment> getAllComments(Integer postId);
    void deleteComment(Integer commentId);
    void deleteAllComments(Integer postId);
    void updateComment(Comment comment);
}
