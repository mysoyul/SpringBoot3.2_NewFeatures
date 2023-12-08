package dev.boot3.blogpost.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebConfig {
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
