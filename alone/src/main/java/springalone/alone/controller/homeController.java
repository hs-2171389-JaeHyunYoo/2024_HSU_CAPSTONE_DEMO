package springalone.alone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import springalone.alone.domain.Post;
import springalone.alone.repository.MemoryPostRepository;
import springalone.alone.service.PostService;

@Controller
public class homeController {
    private final MemoryPostRepository memoryPostRepository;
    private final PostService postService;
    @Autowired
    public homeController(MemoryPostRepository memoryPostRepository, PostService postService) {
        this.memoryPostRepository = memoryPostRepository;
        this.postService = postService;
    }


    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/post/new")
    public String postNew(){
        return "post/new";
    }
    @PostMapping("/post/new")
    public String postForm(PostForm postForm){
        Post post = new Post();
        //작성자
        post.setWriter(postForm.getWriter());
        System.out.println("Writer : "+post.getWriter());


        post.setContents(postForm.getContent());
        System.out.println("Content : "+post.getContents());

        post.setTitle(postForm.getTitle());
        System.out.println("Title : " + post.getTitle());


        memoryPostRepository.save(post);


        return "redirect:/";
    }
}
