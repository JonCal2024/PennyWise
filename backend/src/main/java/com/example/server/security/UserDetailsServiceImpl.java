package com.example.server.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.server.entities.User;
import com.example.server.interfaces.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) { // Query to get User details to user for authentication purposes

        Optional<User> userQuery = userRepository.findByEmail(email);
        if (userQuery.isPresent()) {
            User user = userQuery.get();
        
            return org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .build();
        } else {
            throw new UsernameNotFoundException("User does not exist");
        }
        
    }
    
}
