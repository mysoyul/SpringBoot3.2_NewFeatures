package dev.boot3.blogpost.controller;

import dev.boot3.blogpost.client.JsonPlaceholderService;
import dev.boot3.blogpost.model.Post;
import dev.boot3.blogpost.service.PostServiceRestClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostControllerRestClient {
    //private final JsonPlaceholderService postService;
    private final PostServiceRestClient postService;

    @GetMapping
    public List<Post> findAll() {

        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id) {

        return postService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post) {

        return postService.create(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Integer id, @RequestBody Post post) {

        return postService.update(id, post);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id) {

        postService.delete(id);
    }
}
