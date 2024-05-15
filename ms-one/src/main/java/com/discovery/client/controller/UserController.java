package com.discovery.client.controller;

import com.discovery.client.dto.PostDto;
import com.discovery.client.services.client.PostFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    private PostFeignClient postFeignClient;

    public UserController(PostFeignClient postFeignClient) {
        this.postFeignClient = postFeignClient;
    }

    @GetMapping("/users")
    public String[] userList() {
        return new String[] {"one", "two", "threes"};
    }

    @GetMapping("/posts")
    public List<PostDto> getPosts(){
        logger.info("fetching posts from ms-one");
        ResponseEntity<List<PostDto>> postDtoResponseEntity = postFeignClient.fetchPosts();
        return postDtoResponseEntity.getBody();
    }
}
