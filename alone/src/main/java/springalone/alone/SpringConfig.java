package springalone.alone;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springalone.alone.repository.JpaPostRepository;
import springalone.alone.repository.PostRepository;
import springalone.alone.service.PostService;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {
    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

//    @Bean
//    public PostRepository postRepository(){
//        return new JpaPostRepository(em);
//    }
}
