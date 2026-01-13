package com.educandoweb.course.controllers;

import com.educandoweb.course.entities.Product;
import com.educandoweb.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/post")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product savedProduct = service.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProduct);
    }

    @GetMapping("/getProduct/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable Long id){
        Product product = service.findProduct(id);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
