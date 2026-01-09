package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date moment;
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
    @OneToMany
    private List<OrderItem> items = new ArrayList<>();


    public Order() {
    }

    public Order(Date moment, OrderStatus orderStatus) {
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

    public void setOrderStatus(OrderStatus status) {
        this.orderStatus = status;
    }

    public OrderStatus getOrderStatus(){
        return orderStatus;
    }

    public double total(){
        double sum = 0.0;
        for(OrderItem orderItem : items){
            sum += orderItem.getPrice();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof Order)) return false;
        Order other = (Order) o;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
