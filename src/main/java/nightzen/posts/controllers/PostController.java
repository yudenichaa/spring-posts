package nightzen.posts.controllers;

import nightzen.posts.entities.Post;
import nightzen.posts.services.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public PostController(@Autowired PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<Post> getAllPost() {
        return postService.getAllPosts();
    }

    @GetMapping("/{id}")
    public Post getPost(@PathVariable Long id) {
        return postService.getPost(id);
    }

    @PostMapping
    public Post addPost(@RequestBody Post post) {
        return postService.addPost(post);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Long id, @RequestBody Post post) {
        return postService.updatePost(id, post);
    }

    @PatchMapping("/{id}")
    public Post patchPost(@PathVariable Long id, @RequestBody Map<String, Object> partialPost) {
        return postService.patchPost(id, partialPost);
    }

    @PatchMapping("/{id}/title")
    public void updateTitle(@PathVariable Long id, @RequestBody String title) {
        postService.updateTitle(id, title);
    }
}

