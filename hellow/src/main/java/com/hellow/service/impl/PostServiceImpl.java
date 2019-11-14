package com.hellow.service.impl;

import com.hellow.entity.Post;
import com.hellow.repository.PostRepository;
import com.hellow.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post.getPostText(), post.getPostName(), post.getPostCreator());
        postRepository.flush();
    }

    @Override
    public void updatePost(Post post) {
        postRepository.updatePost(post.getId(), post.getPostText(), post.getPostName());
        postRepository.flush();
    }

    @Override
    public void deletePost(Integer id) {
        postRepository.deletePost(id);
        postRepository.flush();
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAllPosts();
    }

    @Override
    public Post getPost(Integer id) {
        return  postRepository.findOne(id);
    }


}
