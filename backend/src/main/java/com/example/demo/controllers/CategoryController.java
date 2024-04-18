package com.example.demo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CategoryRequest;
import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;  
    //private BudgetService budgetService;

    @Autowired
    public CategoryController(CategoryService categoryService/* , BudgetService budgetService*/) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public Category addCategory(@RequestBody CategoryRequest categoryRequest) {
        String budgetName = categoryRequest.name();
        //ObjectId budgetID = budgetService.findByName();
        Category category = new Category(categoryRequest.amount_allocated(),
                                         categoryRequest.name(), 
                                         categoryRequest.description(),
                                         null);
        categoryService.addCategory(category);
        return category;
    }

    @PostMapping("/removeCategory")
    public void removeCategory(@RequestBody Category category) {

    }

}