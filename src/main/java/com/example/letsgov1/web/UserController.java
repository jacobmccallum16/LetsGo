package com.example.letsgov1.web;

import com.example.letsgov1.entities.User;
import com.example.letsgov1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String users(Model model) {
        List<User> users = userRepository.findAll();
        model.addAttribute("listUsers", users);
        return "users";
    }
}
