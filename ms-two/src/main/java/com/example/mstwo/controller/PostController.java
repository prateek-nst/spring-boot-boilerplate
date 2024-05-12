package com.example.mstwo.controller;

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

    @GetMapping
    public List<Post> getPosts() {
        return List.of(new Post(1, "post 1"), new Post(2, "post 2"));
    }
}
