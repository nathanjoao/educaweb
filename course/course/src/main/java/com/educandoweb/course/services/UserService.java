package com.educandoweb.course.services;

import com.educandoweb.course.entities.User;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity<List<User>> findAll() {
        List<User> users = repository.findAll();
        return ResponseEntity.ok().body(users);
    }

    public ResponseEntity<User> save(User user) {
        User savedUser = repository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
    }

    public ResponseEntity<User> findUser(Long id) {
        return repository.findById(id).map(user -> ResponseEntity.ok(user))
                .orElse(ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> findUserByName(String name) {
        return repository.findByName(name).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        /*
         * ResponseEntity::ok
         * is same as
         * user -> ResponseEntity.ok(user)
         */
    }

    public ResponseEntity<Void> deleteUser(Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build(); // HTTP 204
    }
}
