package dev.boot3.blogpost;

import dev.boot3.blogpost.client.JsonPlaceholderService;
import dev.boot3.blogpost.model.Post;
import dev.boot3.blogpost.repository.PostRepository;
import dev.boot3.blogpost.service.PostService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.List;

@SpringBootApplication
public class Boot3BlogpostAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot3BlogpostAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(PostService postService, PostRepository postRepository) {
//		return args -> {
//			List<Post> posts = postService.loadPosts();
//			postRepository.saveAll(posts);
//		};
//	}

//	@Bean
//	CommandLineRunner commandLineRunner(PostRepository postRepository) {
//		return args -> {
//			WebClient client = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
//			HttpServiceProxyFactory factory =
//					HttpServiceProxyFactory.builder(WebClientAdapter.forClient(client)).build();
//			JsonPlaceholderService jps = factory.createClient(JsonPlaceholderService.class);
//			System.out.println("====> Proxy class name = " + jps.getClass().getName());
//			List<Post> posts = jps.loadPosts();
//			postRepository.saveAll(posts);
//		};
//	}

	//RestClient를 사용해서 HttpInterface의 Proxy 객체를 생성하기

	@Bean
	JsonPlaceholderService jsonPlaceholderService() {
		RestClient client = RestClient.create("https://jsonplaceholder.typicode.com");
		HttpServiceProxyFactory factory = HttpServiceProxyFactory
				.builderFor(RestClientAdapter.create(client))
				.build();
		return factory.createClient(JsonPlaceholderService.class);
	}

}
