package com.example.server.interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.server.entities.User;

public interface UserRepository extends MongoRepository<User, Long>{
    User findByID(Long id);
}
