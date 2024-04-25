package com.example.demo.services;

import java.util.List;

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
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category) {
            categoryRepository.save(category);
        
    }

    public void removeCategory(Category category) {
        categoryRepository.deleteByName(category.getName());
    }

    public List<Category> findAllCategoriesByBudgetID(ObjectId budgetID) {
        return categoryRepository.findByBudgetID(budgetID);
    }

}
