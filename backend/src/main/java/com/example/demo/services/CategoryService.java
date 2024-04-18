package com.example.demo.services;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Category;
import com.example.demo.interfaces.CategoryRepository;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category findByID(ObjectId id) {
        return categoryRepository.findByID(id).orElse(null);
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
    
    public void removeCategory(Category category) {
        categoryRepository.delete(category);
    }

}
