package com.example.demo.interfaces;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.entities.User;

public interface UserRepository extends MongoRepository<User, String>{
    Optional<User> findByID(String id);
    Optional<User> findByEmail(String email); 
}
