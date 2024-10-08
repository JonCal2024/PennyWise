package com.example.demo.controllers;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.User;
import com.example.demo.security.JwtHelper;
import com.example.demo.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userRepo;
    private final AuthenticationManager authenticationManager;
  

    @Autowired
    public UserController(UserService userRepo, AuthenticationManager authenticationManager) {
        this.userRepo = userRepo;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) 
    {
        userRepo.signup(user);
        return user.getEmail();
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User requestingUser)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(requestingUser.getEmail(), requestingUser.getPassword()));
        String token = JwtHelper.generateToken(requestingUser.getEmail());
        return token;
    }

    @GetMapping("/{id}")
    public User getUserByID(@PathVariable ObjectId id) {
        return userRepo.findByID(id); 
    }
 
    @PatchMapping("/{id}/{password}") 
    public User updateUser(@PathVariable ObjectId id, @RequestBody String password) {
        return userRepo.updateUser(id, password);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable ObjectId id) {
        userRepo.deleteUser(id);
    }

}
