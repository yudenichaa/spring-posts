package nightzen.posts.repositories;

import nightzen.posts.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface PostRepository extends JpaRepository<Post, Long> {

    @Transactional
    @Modifying
    @Query("update Post p set p.title = :title where p.id = :id")
    void updateTitle(@Param("id") Long id, @Param("title") String title);
}
