package springalone.alone.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import springalone.alone.domain.Post;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;

class MemoryPostRepositoryTest {
    MemoryPostRepository repository = new MemoryPostRepository();
    @Test
    public void save() {
        Post post = new Post();
        post.setContents("content1");
        post.setTitle("title1");
        post.setWriter("writer1");

        repository.save(post);


//        Post result2 = repository.findWithTitle(post.getTitle()).get();
//        System.out.println("findWithTitle Test Result ==> "+ (result2 == post));

    }

    @Test
    public void findWithTitle(){
        Post post2 = new Post();
        post2.setWriter("writer2");
        post2.setTitle("title2");
        post2.setContents("content2");

        Post post3 = new Post();
        post3.setWriter("writer3");
        post3.setTitle("title3");
        post3.setContents("content3");


        repository.save(post2);
        repository.save(post3);

        Post titleTestResult = repository.findWithTitle("title2").get();
        Assertions.assertThat(titleTestResult).isEqualTo(post2);

    }

    @Test
    public void findAll(){
        Post post2 = new Post();
        post2.setWriter("writer2");
        post2.setTitle("title2");
        post2.setContents("content2");
        repository.save(post2);

        Post post3 = new Post();
        post3.setWriter("writer3");
        post3.setTitle("title3");
        post3.setContents("content3");
        repository.save(post3);

        Post post4 = new Post();
        post4.setContents("content4");
        post4.setTitle("title4");
        post4.setWriter("writer4");
        repository.save(post4);

        List<Post> findAllResult = repository.findAll();
        Assertions.assertThat(findAllResult.size()).isEqualTo(3);
    }
}
