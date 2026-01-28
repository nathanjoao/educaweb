package com.educandoweb.course.controllers;

import com.educandoweb.course.entities.Order;
import com.educandoweb.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/post")
    public ResponseEntity<Order> save(@RequestBody Order order, @RequestBody Long userId,
                                      @RequestBody List<Long> productsIds, @RequestBody Long paymentId){
        Order savedOrder = service.save(order, userId, productsIds, paymentId);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrder);
    }
}
