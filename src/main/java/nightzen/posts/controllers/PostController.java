package nightzen.posts.controllers;

import nightzen.posts.entities.Post;
import nightzen.posts.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

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
}

