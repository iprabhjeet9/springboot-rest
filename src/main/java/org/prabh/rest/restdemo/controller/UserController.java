package org.prabh.rest.restdemo.controller;

import org.prabh.rest.restdemo.repository.UserRepo;
import org.prabh.rest.restdemo.users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
    private final UserRepo userRepo;

    public UserController(UserRepo userRepo){
        this.userRepo=userRepo;
        userRepo.saveAll(List.of(new User("Ram"),new User("Sham"),new User("Bharat")));
    }

    @GetMapping("/v1/users")
    Iterable<User> getAllUser(){
        return userRepo.findAll();
    }

    @GetMapping("/v1/users/{id}")
    Optional<User> getOneUser(@PathVariable String id){
        return userRepo.findById(id);
    }

    @PostMapping("/v1/users")
    User createUser(@RequestBody User user){
        return userRepo.save(user);
    }

    @PutMapping("/v1/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
        return (userRepo.existsById(id))?new ResponseEntity<>(userRepo.save(user), HttpStatus.OK):
                new ResponseEntity<>(userRepo.save(user), HttpStatus.CREATED);
    }

    @DeleteMapping("/v1/users/{id}")
    void deleteUser(@PathVariable String id){
        userRepo.deleteById(id);
    }
}
