package com.hellow.service;

import com.hellow.entity.Post;

import java.util.List;

public interface PostService {
    void addPost(Post post);
    void updatePost(Post post);
    void deletePost(Integer postId);
    List<Post> getAllPosts();
    Post getPost(Integer postId);
}
