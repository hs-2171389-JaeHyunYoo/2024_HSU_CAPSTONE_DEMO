package springalone.alone.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springalone.alone.domain.Post;
import springalone.alone.repository.MemoryPostRepository;
import springalone.alone.repository.PostRepository;

@Transactional
@Service
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService (PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Long enroll(Post post){

        postRepository.save(post);

        return post.getId();
    }


}
