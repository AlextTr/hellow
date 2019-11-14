package com.hellow.service.impl;

import com.hellow.entity.Comment;
import com.hellow.repository.CommentRepository;
import com.hellow.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentRepository commentRepository;

    @Override
    public void addComment(Comment comment) {
        commentRepository.save(comment.getCommentText(), comment.getCommentOwner(), comment.getPostId());
        commentRepository.flush();
    }

    @Override
    public Comment getComment(Integer commentId) {
        return commentRepository.findOne(commentId);
    }

    @Override
    public List<Comment> getAllComments(Integer postId) {
        return new ArrayList<>(commentRepository.findAllComments(postId));
    }

    @Override
    public void deleteComment(Integer commentId) {
        commentRepository.deleteComment(commentId);
        commentRepository.flush();
    }

    @Override
    public void deleteAllComments(Integer postId) {
        commentRepository.deleteAllComments(postId);
        commentRepository.flush();
    }

    @Override
    public void updateComment(Comment comment) {
        commentRepository.updateComment(comment.getId(), comment.getCommentText(), comment.getCommentOwner());
        commentRepository.flush();
    }
}
