package dev.boot3.blogpost.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
public class Post {
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    private String body;
}