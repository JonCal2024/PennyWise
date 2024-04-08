package com.example.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.server.entities.User;
import com.example.server.interfaces.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepo;

    @Autowired
    public UserController(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User requestingUser)
    {
        return userRepo.findByID(requestingUser.getID());
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }
 
    @PatchMapping("/{id}/{password}")
    public User updateUser(@PathVariable Long id, @RequestBody String password) {
        User user = userRepo.findById(id).orElse(null);
        if(password != null && user != null)
        {
            user.setPassword(password);
            return userRepo.save(user);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
