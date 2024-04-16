package springalone.alone.repository;

import jakarta.persistence.EntityManager;
import springalone.alone.domain.Post;

import java.util.List;
import java.util.Optional;

public class JpaPostRepository implements PostRepository{
    private final EntityManager em;

    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Post save(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public Optional<Post> findWithWriter(String writer) {
        Post post = em.find(Post.class, writer);
        return Optional.ofNullable(post);
    }

    @Override
    public Optional<Post> findWithTitle(String title) {
        List<Post> result =  em.createQuery("select p from Post p where p.title = :title", Post.class)
                .setParameter("title", title)
                .getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Post> findAll() {
        return em.createQuery("select p from Post p", Post.class)
                .getResultList();
    }
}
