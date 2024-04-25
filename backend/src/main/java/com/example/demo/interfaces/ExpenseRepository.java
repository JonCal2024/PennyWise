package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, ObjectId>{
    Optional<Expense> findById(ObjectId id);
    List<Expense> findByCategoryID(ObjectId categoryID);
}
