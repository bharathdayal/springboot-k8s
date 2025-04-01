package com.example.demo.services;

import com.example.demo.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserById(Long userId);

    List<User> getAllUsers();

    User updateUser(User user);

    void deleteUser(Long userId);

    User findByUserEmail(String userEmail);

    User findByUsername(String userName);

    User findByUsernameOrEmail(String username,String email);

    String findByUsernameAll(String username);
}