package com.example.server.interfaces;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.server.entities.User;

public interface UserRepository extends MongoRepository<User, Long>{
    User findByID(Long id);
    Optional<User> findByEmail(String email);
}
