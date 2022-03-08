package nightzen.posts;

import nightzen.posts.entities.Post;
import nightzen.posts.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;

@SpringBootApplication
public class PostsApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final PostRepository postRepository;

    public PostsApplication(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public void run(String... args) {
        postRepository.deleteAll();
        logger.info("\n\n>>Inserting Player: {}\n",
                postRepository.save(new Post("Post 1", "Post text 1", Date.valueOf("1987-05-22"), Date.valueOf("1987-05-22"))));
        logger.info("\n\n>>Inserting Player: {}\n",
                postRepository.save(new Post("Post 2", "Post text 2", Date.valueOf("1987-05-23"), Date.valueOf("1987-05-23"))));
        logger.info("\n\n>>All Players Data: {}\n", postRepository.findAll());
    }

    public static void main(String[] args) {
        SpringApplication.run(PostsApplication.class, args);
    }

}
