package com.hellow.controller;

import com.hellow.entity.Post;
import com.hellow.entity.UserInSystem;
import com.hellow.service.impl.CommentServiceImpl;
import com.hellow.service.impl.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController  {

    @Autowired
    private PostServiceImpl postService;

    @Autowired
    private CommentServiceImpl commentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String mainPage(Model model){
        model.addAttribute("title","Enter your name");
        UserInSystem user = new UserInSystem();
        model.addAttribute("user", user);
        return "main";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String getUser(@RequestParam String userName){
        if(userName.equals("")){
            return "redirect:/";
        }
        UserInSystem.setUserName(userName);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/allPosts", method = RequestMethod.GET)
    public String showAllPosts(Model model){
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "allposts";
    }

    @RequestMapping(value = "/watchPost/{id}", method = RequestMethod.GET)
    public String showSelectedPost(@PathVariable Integer id, Model model){
        Post post = postService.getPost(id);
        model.addAttribute("post", post);
        model.addAttribute("user", new UserInSystem().getUserName());
        model.addAttribute("comments", new ArrayList<>(commentService.getAllComments(post.getId())));
        return "watchpost";
    }

    @RequestMapping(value = "/updatePost/{id}", method = RequestMethod.GET)
    public String showFormForUpdateSelectedPost(@PathVariable Integer id, Model model){
        Post post = postService.getPost(id);
        model.addAttribute("updatethispost", post);
        return "updatepost";
    }

    @RequestMapping(value = "/updatePost", method = RequestMethod.POST)
    public String updateSelectedPost(@ModelAttribute("updatethispost") Post post){
        postService.updatePost(post);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/deletePost/{id}", method = RequestMethod.GET)
    public String deleteSelectedPost(@PathVariable Integer id){
        postService.deletePost(id);
        return "redirect:/allPosts";
    }

    @RequestMapping(value = "/postCreate", method = RequestMethod.GET)
    public String showAddPostForm(Model model){
        Post post = new Post();
        model.addAttribute("newpost",post);
        return "postcreate";
    }

    @RequestMapping(value = "/postCreate", method = RequestMethod.POST)
    public String addPost(@RequestParam String postText, @RequestParam String postName){
        Post post = new Post();
        post.setPostName(postName);
        post.setPostText(postText);
        post.setPostCreator(new UserInSystem().getUserName());
        postService.addPost(post);
        return "redirect:/allPosts";
    }
}