package com.example.letsgov1.web;

import com.example.letsgov1.entities.User;
import com.example.letsgov1.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public String redirectUsers() {
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String users(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<User> users;
        if (keyId.isEmpty()) {
            users = userRepository.findAll();
        } else {
            long id = Long.parseLong(keyId);
            users = userRepository.findUserById(id);
        }
        model.addAttribute("listUsers", users);
        return "users";
    }

    @GetMapping("/newUser")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping("/createNewUser")
    public String save(Model model, User user, BindingResult bindingResult,
                       ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        } else {
            if (user.getIsAdmin() == true) {user.setIsAdmin(false);}
            user.setTimesRated(0);
            user.setOverallSafetyScore(0.0);
            user.setOverallSafetyRating(0.0);
            user.setOverallResponsibilityRating(0.0);
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
            return "redirect:users";
        }
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Long id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }
}
