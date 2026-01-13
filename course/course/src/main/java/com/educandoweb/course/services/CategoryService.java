package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public Category save(Category category){
        return repository.save(category);
    }

    public Category findCategory(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
    }

    public void deleteCategory(Long id){
        if(!repository.existsById(id)){
            throw new RuntimeException("Category not found");
        }
        repository.deleteById(id);
    }

    public List<Category> findAll(){
        return repository.findAll();
    }
}
