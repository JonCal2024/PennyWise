package com.example.demo.interfaces;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Budget;

public interface BudgetRepository extends MongoRepository<Budget, ObjectId>{
    Optional<Budget> findByID(ObjectId id);
    List<Budget> findByUserID(ObjectId user_id);
}  
