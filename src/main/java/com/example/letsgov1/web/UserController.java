package com.example.letsgov1.web;

import com.example.letsgov1.repositories.DriverRepository;
import com.example.letsgov1.repositories.RiderRepository;
import com.example.letsgov1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserRepository userRepository;
    private RiderRepository riderRepository;
    private DriverRepository driverRepository;

    @GetMapping("/")
    public String redirectIndex() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String redirectUsers() {
        return "redirect:/admin/users";
    }
}
