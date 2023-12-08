package dev.boot3.blogpost.repository;

import dev.boot3.blogpost.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListCrudRepository;

public interface PostRepository extends ListCrudRepository<Post,Integer> {

}