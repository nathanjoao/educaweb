package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date moment;
    private String orderStatus;
    @OneToMany
    private List<OrderItem> items = new ArrayList<>();

    public Order() {
    }

    public Order(Date moment, String orderStatus) {
        this.moment = moment;
        this.orderStatus = orderStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem orderItem : items){
            sum += orderItem.getPrice();
        }
        return sum;
    }
}
