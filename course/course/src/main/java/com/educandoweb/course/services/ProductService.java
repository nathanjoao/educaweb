package com.educandoweb.course.services;

import com.educandoweb.course.entities.Category;
import com.educandoweb.course.entities.Product;
import com.educandoweb.course.repositories.CategoryRepository;
import com.educandoweb.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;
    @Autowired
    private CategoryRepository categoryRepository;

    public Product save(Product product) {
        List<Long> categoriesIds = product.getCategories().stream().map(Category::getId).toList();
        List<Category> categories = categoryRepository.findAllById(categoriesIds);
        if(categories.isEmpty()){
            throw new RuntimeException("Categories not found");
        }
        product.getCategories().clear();
        product.getCategories().addAll(categories);
        return repository.save(product);
    }

    public Product findProduct(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        repository.deleteById(id);
    }
}
