package dev.boot3.blogpost.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponseException;

import java.net.URI;
import java.time.Instant;

public class MyNotFoundException extends ErrorResponseException {
    public MyNotFoundException(Integer id) {
        super(HttpStatus.NOT_FOUND, asProblemDetail("Customer with id "+ id+" not found"), null);//
    }

    private static ProblemDetail asProblemDetail(String message) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, message);
        problemDetail.setTitle("Customer Not Found");
        problemDetail.setType(URI.create("https://localhost:8080/errors/not-found"));
        problemDetail.setProperty("errorCategory", "Generic");
        problemDetail.setProperty("timestamp", Instant.now());
        return problemDetail;
    }
}
