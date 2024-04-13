package com.example.demo.services;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entities.User;
import com.example.demo.interfaces.UserRepository;

// Provides business logic, Controller should use instance of UserService
@Service
public class UserService {
    
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User findByEmail(String email) throws Exception {
        Optional<User> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new Exception("User already exists");
        }

        return existingUser.get();
    }
    
    public User findByID(String id) {
        return userRepository.findByID(id).orElse(null);
    }

    public void signup(User user) throws Exception { // Logic for registering a user (Insert to DB)
        String email = user.getEmail();
        Optional<User> existingUser = userRepository.findByEmail(email);

        if (existingUser.isPresent()) {
            throw new Exception("User already exists");
        }

        String hashedPassword = passwordEncoder.encode(user.getPassword());
        User registeredUser = new User(user.getUsername(), 
                                       hashedPassword, 
                                       email);
        userRepository.save(registeredUser);

    }

    public User updateUser(String id, String password) {
        User user = userRepository.findByID(id).orElse(null);
        if(password != null && user != null)
        {
            user.setPassword(password);
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

}
