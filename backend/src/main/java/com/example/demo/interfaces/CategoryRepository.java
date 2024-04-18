package com.example.demo.interfaces;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Category;

public interface CategoryRepository extends MongoRepository<Category, ObjectId>{
    Optional<Category> findByID(ObjectId id);
    Optional<Category> findByName(String name);
}