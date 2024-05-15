package com.example.mstwo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

class Post {
    private long id;
    private String content;

    public Post(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

@RestController
@RequestMapping("/posts")
public class PostController {

    private static Logger logger = LoggerFactory.getLogger(PostController.class);

    @GetMapping
    public List<Post> getPosts() {
        logger.info("fetching posts from ms-two");
        return List.of(new Post(1, "post 1"), new Post(2, "post 2"));
    }
}
