package com.discovery.client.services.client;

import com.discovery.client.dto.PostDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("ms-two")
public interface PostFeignClient {
    @GetMapping(value = "/posts")
    public ResponseEntity<List<PostDto>> fetchPosts();
}
