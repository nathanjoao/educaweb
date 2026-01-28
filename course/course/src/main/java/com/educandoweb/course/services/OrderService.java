package com.educandoweb.course.services;

import com.educandoweb.course.entities.*;
import com.educandoweb.course.repositories.OrderRepository;
import com.educandoweb.course.repositories.ProductRepository;
import com.educandoweb.course.repositories.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;


    public Order save(Order order, Long userId, List<Long> productsIds, Long paymentId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        order.setUser(user);
        if(paymentId == null) throw new RuntimeException("There's no payment");
        List<Product> products = productRepository.findAllById(productsIds);
        if (products.isEmpty()) throw new RuntimeException("There's no product in the list");
        for (Product product : products) {
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(1);
            order.getOrderItems().add(orderItem);
        }
        order.setOrderStatus(OrderStatus.SHIPPED);
        order.setMoment(new Date());
        user.getOrders().add(order);
        return orderRepository.save(order);
    }
}
