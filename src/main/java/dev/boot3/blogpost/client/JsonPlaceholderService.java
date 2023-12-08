package dev.boot3.blogpost.client;

import dev.boot3.blogpost.model.Post;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

import java.util.List;

public interface JsonPlaceholderService {
//    @GetExchange("/posts")
//    List<Post> loadPosts();

    @GetExchange("/posts")
    List<Post> findAll();

    @GetExchange("/posts/{id}")
    Post findById(Integer id);

    @PostExchange("/posts")
    Post create(Post post);

    @PutExchange("/posts/{id}")
    Post update(@PathVariable Integer id, Post post);

    @DeleteExchange("/posts/{id}")
    void delete(@PathVariable Integer id);

}