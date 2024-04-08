package com.example.server.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.entities.User;
import com.example.server.interfaces.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user)
    {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public boolean loginUser(@RequestBody User requestingUser)
    {
        User user = userRepo.findByID(requestingUser.getID());

        if(user != null)
        {
            return true;
        }
        return false;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @PutMapping("/{password}")
    public User updateUser(@PathVariable String password, @RequestBody User updatingUser) {
        updatingUser.setPassword(password);
        return userRepo.save(updatingUser);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepo.deleteById(id);
    }
}
