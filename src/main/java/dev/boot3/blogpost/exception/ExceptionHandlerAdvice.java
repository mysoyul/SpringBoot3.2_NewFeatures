package dev.boot3.blogpost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.net.URI;
import java.time.Instant;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(PostNotFoundException.class)
    public ProblemDetail handlePostNotFoundException(PostNotFoundException e) throws Exception{
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
        problemDetail.setTitle("Post Not Found");
        problemDetail.setProperty("postId", e.getId());
        problemDetail.setType(new URI("http://localhost:8080/problems/post-not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }

    @ExceptionHandler(MyNotFoundException.class)
    public ErrorResponse handleMyNotFoundException(MyNotFoundException e) {
        return ErrorResponse.builder(e, e.getBody())
                .build();
    }
}
