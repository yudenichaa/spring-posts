package nightzen.posts.controllers;

import nightzen.posts.entities.Post;
import nightzen.posts.services.PostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@ExtendWith(MockitoExtension.class)
public class PostControllerTests {
    @Mock
    PostService postService;

    @InjectMocks
    PostController postController;

    @Test
    void testGetAllPosts_noPosts() {
        List<Post> expectedResult = new ArrayList<>();
        when(postService.getAllPosts()).thenReturn(expectedResult);
        assertArrayEquals(expectedResult.toArray(), postController.getAllPosts().toArray());
    }

    @Test
    void testGetAllPosts_somePosts() {
        List<Post> expectedResult = new ArrayList<>();
        expectedResult.add(new Post(1L, "Post 1", "Post 1 text", Date.valueOf("1987-05-21"), Date.valueOf("1987-05-21")));
        expectedResult.add(new Post(2L, "Post 2", "Post 2 text", Date.valueOf("1988-05-21"), Date.valueOf("1988-05-21")));
        when(postService.getAllPosts()).thenReturn(expectedResult);
        assertArrayEquals(expectedResult.toArray(), postController.getAllPosts().toArray());
    }
}
