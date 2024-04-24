package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, ObjectId>{
    Optional<Category> findById(ObjectId id);
    Optional<Category> findByName(String name);
    List<Category> findByBudgetId(ObjectId budgetID);
    void deleteByName(String name);
}