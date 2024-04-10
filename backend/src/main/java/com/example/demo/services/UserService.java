package com.example.demo.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.entities.User;
import com.example.demo.interfaces.UserRepository;

// Provides business logic, Controller should use instance of UserService
public class UserService {
    
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void signup(User user) throws Exception { // Logic for registering a user (Insert to DB)
        String email = user.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            throw new Exception("User already exists");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        // User registeredUser = new User(user.getUsername(), 
        //                                hashedPassword, 
        //                                email);
        user.setPassword(hashedPassword);
        userRepository.save(user);

    }

}
