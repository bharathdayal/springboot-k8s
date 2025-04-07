package com.example.demo.controllers;

import com.example.demo.Person;
import com.example.demo.model.Book;
import lombok.AllArgsConstructor;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {

    private UserService userService;

    // build create User REST API
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // build get user by id REST API
    // http://localhost:8080/api/users/1
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long userId){
        User user = userService.getUserById(userId);
        System.out.println(userService.getUserById(Long.valueOf("1")));
        System.out.println(userService.getUserById(Long.valueOf("1")));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Build Get All Users REST API
    // http://localhost:8080/api/users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
    //Build Get Only specific User filtering using email
    @GetMapping(path="/email")
    public ResponseEntity<User> getUserEmail(@RequestParam String userEmail)  {
        User user=userService.findByUserEmail(userEmail);
        System.out.println(user.getEmail());
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //Build Get Only specific User filtering using username
    @GetMapping(path="name")
    public ResponseEntity<User> getUserName(@RequestParam String userName) {
        User user = userService.findByUsername(userName);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Build Get Only specific User filtering using username or email
    @GetMapping(path="search")
    public ResponseEntity<User> getUsernameOrEmail(@RequestParam String username, String email) {
        User user =userService.findByUsernameOrEmail(username,email);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    // //Build Get Only specific User filtering using username by Hibernate Named Query

    @GetMapping(path="userall")
    public ResponseEntity<String> getUsernameByAll(@RequestParam String userName) {
        String user = userService.findByUsernameAll(userName);
        System.out.println("USER QUERY===>" + user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    // Build Update User REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/users/1
    public ResponseEntity<User> updateUser(@PathVariable("id") Long userId,
                                           @RequestBody User user){
        user.setId(userId);
        User updatedUser = userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Build Delete User REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

    @GetMapping(path="/person")
    public Person getPerson() {
        Person person = new Person("Bharath",39);
        return person;
    }

}