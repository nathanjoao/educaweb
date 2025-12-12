package com.educandoweb.course.Resources;

import com.educandoweb.course.Entities.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping("/all")
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "Nathan", "nathan@gmail.com", "999", "123");
        return ResponseEntity.ok().body(u);
    }
}
