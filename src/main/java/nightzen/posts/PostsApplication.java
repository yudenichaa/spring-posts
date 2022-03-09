package nightzen.posts;

import nightzen.posts.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PostsApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PostRepository postRepository;

    public PostsApplication(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {
        logger.info("All Players Data: {}", postRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }

}
