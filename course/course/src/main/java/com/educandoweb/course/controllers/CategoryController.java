package com.educandoweb.course.controllers;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @PostMapping("/post")
    public ResponseEntity<Category> save(@RequestBody Category category){
        Category savedCategory = service.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @GetMapping("/getCategoryById/{id}")
    public ResponseEntity<Category> findCategory(@PathVariable Long id){
        Category category = service.findCategory(id);
        return ResponseEntity.ok(category);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categories = service.findAll();
        return ResponseEntity.ok(categories);
    }

    @DeleteMapping("/delete/{od}")
    public ResponseEntity<Void> delete(Long id){
        service.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
