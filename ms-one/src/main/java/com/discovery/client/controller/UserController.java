package com.discovery.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;

@RestController
@RequestMapping("/users")
public class UserController {

    @GetMapping
    public String[] userList() {
        return new String[] {"one", "two", "three"};
    }
}
