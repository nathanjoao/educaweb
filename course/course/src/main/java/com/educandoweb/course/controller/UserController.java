package com.educandoweb.course.controller;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import com.educandoweb.course.services.UserService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/post")
    public ResponseEntity<User> save(@RequestBody User user){
        return service.save(user);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> findAll() {
        return service.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public ResponseEntity<User> findUser(@PathVariable Long id){
        return service.findUser(id);
    }

    @GetMapping("/getUserByName/{name}")
    public ResponseEntity<User> findUserByName(@PathVariable String name){
        return service.findUserByName(name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        service.deleteUser(id);
    }
}
