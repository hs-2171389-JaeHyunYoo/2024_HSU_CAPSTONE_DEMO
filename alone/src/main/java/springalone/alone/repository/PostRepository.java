package springalone.alone.repository;

import springalone.alone.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post save(Post post);
    Optional<Post> findWithWriter(String writer);
    Optional<Post> findWithTitle(String title);
    List<Post> findAll();
}
