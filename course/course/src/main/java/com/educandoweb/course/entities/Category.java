package com.educandoweb.course.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(){}

    public Category(String name){
        this.name = name;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return false;
        if(!(o instanceof Category)) return false;
        Category other = (Category) o;
        return id != null && Objects.equals(id, other.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}
