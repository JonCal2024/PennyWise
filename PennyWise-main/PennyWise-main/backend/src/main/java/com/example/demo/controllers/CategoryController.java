package com.example.demo.controllers;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Category;
import com.example.demo.services.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryController {
    private CategoryService categoryService;  

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/addCategory")
    public void addCategory(@RequestBody Category category) {

        categoryService.addCategory(category);
        
    }

    @DeleteMapping("/removeCategory")
    public void removeCategory(@RequestBody Category category) {

        categoryService.removeCategory(category);

    }

    @GetMapping("/getAllCategories")
    public List<Category> getAllCategories(ObjectId budgetID) {
        return categoryService.findAllCategoriesByBudgetID(budgetID);
    }

    @GetMapping("/{id}")
    public Category getCategoryByID(@PathVariable ObjectId id) {
        return categoryService.findByID(id);
    }


    @PatchMapping("/updateCategory")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category.getID(), category);
    }

}