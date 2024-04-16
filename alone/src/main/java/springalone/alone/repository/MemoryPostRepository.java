package springalone.alone.repository;

import org.springframework.stereotype.Repository;
import springalone.alone.domain.Post;

import java.util.*;

@Repository
public class MemoryPostRepository implements PostRepository{
    private static Map<Long, Post> store = new HashMap<>();
    private static Long sequence = 0L;

    @Override
    public Post save(Post post) {
        post.setId(++sequence);
        store.put(post.getId(), post);
        //System.out.println("!!!!!!!!!!!!!!!!!!!!"+post.getContents());
        
        return post;
    }

    @Override
    public Optional<Post> findWithWriter(String writer) {
        return Optional.ofNullable(store.get(writer));
    }

    @Override
    public Optional<Post> findWithTitle(String title) {
        return store.values().stream()
                .filter(post -> post.getTitle().equals(title))
                .findAny();
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }
}
