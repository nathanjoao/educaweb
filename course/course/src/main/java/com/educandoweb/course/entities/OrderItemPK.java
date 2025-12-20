package com.educandoweb.course.entities;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OrderItemPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(!(o instanceof OrderItemPK)) return false;
        OrderItemPK other = (OrderItemPK) o;
        return Objects.equals(order, other.order) && Objects.equals(product, other.product);
    }

    @Override
    public int hashCode(){
        return Objects.hash(order, product);
    }
}
