package com.mapping.table.post.service;

import com.mapping.table.post.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {
    Post addPost(Post post);
    List<Post> getAllPost();
    Optional<Post> getPost(Long id);
}
