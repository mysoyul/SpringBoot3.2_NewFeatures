package dev.boot3.blogpost.service;

import dev.boot3.blogpost.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final RestTemplate restTemplate;

    public List<Post> loadPosts() {
        ResponseEntity<List<Post>> exchange = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/posts",
                    HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Post>>() {});
        return exchange.getBody();
    }

}