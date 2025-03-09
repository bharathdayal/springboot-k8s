package com.example.demo.components;

import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Cache implements CommandLineRunner {

    @Autowired
    private final UserService userService;

    public Cache(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void run(String ... args) throws Exception{
        System.out.println(userService.getUserById(Long.valueOf("1")));
        System.out.println(userService.getUserById(Long.valueOf("1")));
    }
}
