package org.prabh.rest.restdemo.controller;

import org.prabh.rest.restdemo.users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class RestControllerDemo {
    private List<User> users = new ArrayList<>();

    public RestControllerDemo() {
        users.addAll(
                List.of(
                        new User("Prabh"),
                        new User("Jeet"),
                        new User("Ram")
                )
        );
    }

    @GetMapping("/users")
    Iterable<User> getAllUsers(){
        return users;
    }

    @GetMapping("/users/{id}")
    Optional<User> getUser(@PathVariable String id){
        for(User u: users){
            if(u.getId().equals(id)){
                return Optional.of(u);
            }
        }
        return Optional.empty();
    }

    @PostMapping("/users")
    User createUser(@RequestBody User user){
        users.add(user);
        return user;
    }

    @PutMapping("/users/{id}")
    ResponseEntity<User> updateUser(@PathVariable String id, @RequestBody User user){
        int Idx =-1;
        for (User u: users){
            if(u.getId().equals(id)){
                Idx=users.indexOf(u);
                users.set(Idx,user);
            }
        }
        return (Idx==-1)? new ResponseEntity<>(createUser(user), HttpStatus.CREATED):
                new ResponseEntity<>(user,HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable String id){
        users.removeIf(c->c.getId().equals(id));
    }
}
