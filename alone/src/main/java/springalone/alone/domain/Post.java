package springalone.alone.domain;

import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="writerDB")
    private String writer;
    private String title;
    private String contents;

    //getter
    public Long getId(){
        return this.id;
    }
    public String getWriter(){
        return this.writer;
    }
    public String getTitle(){
        return this.title;
    }
    public String getContents(){
        return this.contents;
    }


    //setter
    public void setId(Long id){
        this.id = id;
    }
    public void setWriter(String writer){
        this.writer = writer;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setContents(String contents){
        this.contents = contents;
    }

}
