package com.example.demo.interfaces;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, ObjectId>{
    Optional<Expense> findByID(ObjectId id);
    Optional<Expense> findByCategoryID(ObjectId id);
}
