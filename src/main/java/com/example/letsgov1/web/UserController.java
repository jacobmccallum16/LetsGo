package com.example.letsgov1.web;

import com.example.letsgov1.entities.*;
import com.example.letsgov1.repositories.*;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

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
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String users(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<User> users;
        if (keyId.isEmpty()) {
            users = userRepository.findAll();
        } else {
            Integer id = Integer.parseInt(keyId);
            users = userRepository.findUserByUserId(id);
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
            user.setOverallSafetyScore(0f);
            user.setOverallSafetyRating(0f);
            user.setOverallResponsibilityRating(0f);
            user.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
            return "redirect:users";
        }
    }

    @GetMapping("/createRider")
    public String createRider(Integer id, Model model, Rider rider) {
        List<User> users = userRepository.findUserByUserId(id);
        User user = users.get(0);
        model.addAttribute("rider", new Rider(user));
        riderRepository.save(new Rider(user));
        return viewAccount(id, model);
    }

    @GetMapping("/createDriver")
    public String createDriver(Integer id, Model model, Driver driver) {
        model.addAttribute("driver", new Driver(id));
        driverRepository.save(driver);
        return viewAccount(id, model);
    }

    @GetMapping("/deleteUser")
    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/viewAccount")
    public String viewAccount(Integer id, Model model) {
        List<User> users;
        users = userRepository.findUserByUserId(id);
        model.addAttribute("users", users);
        return "viewAccount";
    }
    @GetMapping("/viewFullAccount")
    public String viewFullAccount(Integer id, Model model) {
        List<User> users;
        users = userRepository.findUserByUserId(id);
        model.addAttribute("users", users);
        return "viewFullAccount";
    }
}
