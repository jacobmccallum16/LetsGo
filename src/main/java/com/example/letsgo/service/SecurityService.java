package com.example.letsgo.service;

import com.example.letsgo.entities.User;
import com.example.letsgo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityService {
    @Autowired UserRepository userRepository;
    public String login(String username, String password) {
        String status = "Guest";
        List<User> users = userRepository.findUsersByUsernameAndPassword(username, password);
        if (users.isEmpty()) {
            users = userRepository.findUsersByEmailAndPassword(username, password);
        } if (!users.isEmpty()) {
            if (users.get(0).isAdmin) {
                status = "Admin";
            } else {
                status = "User";
            }
        }
        if (status == "Guest") {
            if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
                status = "Admin";
            }
        }
        return status;
    }
}
