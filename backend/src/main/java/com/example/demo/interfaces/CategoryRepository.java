package com.example.demo.interfaces;

import com.example.demo.entities.Category;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {

}


