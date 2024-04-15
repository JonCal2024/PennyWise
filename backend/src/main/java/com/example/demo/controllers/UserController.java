package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userRepo;

    @Autowired
    public UserController(UserService userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) 
    {
        userRepo.signup(user);
        return user.getEmail();
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User requestingUser)
    {
        return userRepo.findByEmail(requestingUser.getEmail());
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable String id) {
        return userRepo.findByID(id); 
    }
 
    @PatchMapping("/{id}/{password}") 
    public User updateUser(@PathVariable String id, @RequestBody String password) {
        return userRepo.updateUser(id, password);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userRepo.deleteUser(id);
    }

}
