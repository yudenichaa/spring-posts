package nightzen.posts.services;

import nightzen.posts.entities.Post;
import nightzen.posts.repositories.PostRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find post with id " + id));
    }

    public Post addPost(Post post) {
        logger.info(post.toString());

        if (post.getId() != null && postRepository.findById(post.getId()).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Post with id " + post.getId() + " already exists");
        }

        post.setId(0L);
        return postRepository.save(post);
    }
}
