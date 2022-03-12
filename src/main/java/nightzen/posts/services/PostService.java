package nightzen.posts.services;

import nightzen.posts.entities.Post;
import nightzen.posts.exceptions.PostNotFoundException;
import nightzen.posts.repositories.PostRepository;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(@Autowired PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public Post getPost(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException("Unable to find post with id " + id));
    }

    public Post addPost(Post post) {
        post.setId(0L);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, Post post) {
        Post currentPost = postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException("Unable to find post with id " + id));
        post.setId(currentPost.getId());
        return postRepository.save(post);
    }

    // TODO: fix date editor configuration
    // TODO: validate fields
    public Post patchPost(Long id, Map<String, Object> partialPost) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException("Unable to find post with id " + id));

        BeanWrapper postWrapper = new BeanWrapperImpl(post);
        postWrapper.registerCustomEditor(
                Date.class,
                new CustomDateEditor(new SimpleDateFormat("dd-MM-yyyy"), false));
        postWrapper.setPropertyValues(partialPost);
        return postRepository.save(post);
    }

    // TODO: return new post
    // TODO: validate title
    public void updateTitle(Long id, String title) {
        postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException("Unable to find post with id " + id));
        postRepository.updateTitle(id, title);
    }

    public void deletePlayer(Long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new PostNotFoundException("Unable to find post with id " + id));
        postRepository.delete(post);
    }
}
