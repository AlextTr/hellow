package com.hellow.controller;

import com.hellow.entity.Comment;
import com.hellow.entity.UserInSystem;
import com.hellow.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping(value = "/deleteComment/{id}", method = RequestMethod.GET)
    public String deleteSelectedComment(@PathVariable Integer id){
        commentService.deleteComment(id);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/deleteAllComments/{id}", method = RequestMethod.GET)
    public String deleteAllComments(@PathVariable Integer id){
        commentService.deleteAllComments(id);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/commentCreate/{id}", method = RequestMethod.GET)
    public String showCreateCommentForm(@PathVariable Integer id, Model model){
        Comment comment = new Comment();
        comment.setPostId(id);
        model.addAttribute("newcomment", comment);
        return "commentcreate";
    }

    @RequestMapping(value = "/commentCreate", method = RequestMethod.POST)
    public String createComment(@ModelAttribute("newcomment") Comment comment){
        comment.setCommentOwner(new UserInSystem().getUserName());
        commentService.addComment(comment);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/updateComment/{id}", method = RequestMethod.GET)
    public String showFormForUpdateSelectedPost(@PathVariable Integer id, Model model){
        Comment comment = commentService.getComment(id);
        model.addAttribute("updatethiscomment", comment);
        return "updatcomment";
    }

    @RequestMapping(value = "/updateComment", method = RequestMethod.POST)
    public String updateSelectedPost(@ModelAttribute("updatethiscomment") Comment comment){
        Comment comment1 = commentService.getComment(comment.getId());
        comment1.setCommentText(comment.getCommentText());
        commentService.updateComment(comment1);
        return "redirect:/allPosts";
    }
}
