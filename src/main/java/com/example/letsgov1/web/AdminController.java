package com.example.letsgov1.web;

import com.example.letsgov1.entities.Driver;
import com.example.letsgov1.entities.Rider;
import com.example.letsgov1.entities.User;
import com.example.letsgov1.repositories.DriverRepository;
import com.example.letsgov1.repositories.RiderRepository;
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
import java.util.List;

@Controller
@AllArgsConstructor
@SessionAttributes({"section", "page"})
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    private RiderRepository riderRepository;
    private DriverRepository driverRepository;
    public HttpSession httpSession;

    @GetMapping("/admin")
    public String adminHome() {
            return "redirect:/users";
    }

    @GetMapping("/admin/users")
    public String users(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<User> users;
        if (keyId.isEmpty()) {
            users = userRepository.findAll();
        } else {
            Integer id = Integer.parseInt(keyId);
            users = userRepository.findUserByUserId(id);
        }
        model.addAttribute("listUsers", users);
        httpSession.setAttribute("section", "admin");
        httpSession.setAttribute("page", "users");
        return "users";
    }

    @GetMapping("/admin/newUser")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        httpSession.setAttribute("section", "admin");
        httpSession.setAttribute("page", "createUser");
        return "newUser";
    }

    @PostMapping("/admin/createUser")
    public String createUser(Model model, User user, BindingResult bindingResult,
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
            Rider rider = new Rider(user);
            Driver driver = new Driver(user);
            user.setRider(rider);
            user.setDriver(driver);
            userRepository.save(user);
            driverRepository.save(driver);
            riderRepository.save(rider);
            return "redirect:users";
        }
    }

    @GetMapping("/admin/editUser")
    public String editUser(Integer id, Model model) {
        User user = userRepository.findUserByUserId(id).get(0);
        model.addAttribute("user", user);
        httpSession.setAttribute("section", "admin");
        return "editUser";
    }
    @PostMapping("/admin/editUser")
    public String editUser(Integer id, Model model, BindingResult bindingResult,
                           ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "editUser";
        } else {
            User user = userRepository.findUserByUserId(id).get(0);
            Timestamp updatedAt = new Timestamp(System.currentTimeMillis());
            user.setUpdatedAt(updatedAt);
            userRepository.save(user);
            return "redirect:/admin/users";
        }
    }

    @GetMapping("/admin/deleteUser")
    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/admin/viewAccount")
    public String viewAccount(Integer id, Model model) {
        List<User> users;
        users = userRepository.findUserByUserId(id);
        model.addAttribute("users", users);
        httpSession.setAttribute("section", "admin");
        httpSession.setAttribute("page", "viewAccount");
        return "viewAccount";
    }

    @GetMapping("/admin/activateRider")
    public String activateRider(Integer id, Model model) {
        List<User> users = userRepository.findUserByUserId(id);
        model.addAttribute("users", users);
        User user = users.get(0);
        Rider rider = users.get(0).getRider();
        rider.toggleIsActive();
        riderRepository.save(rider);
        user.updateIsActive();
        userRepository.save(user);
        return "viewAccount";
    }
    @GetMapping("/admin/activateDriver")
    public String activateDriver(Integer id, Model model) {
        List<User> users = userRepository.findUserByUserId(id);
        model.addAttribute("users", users);
        User user = users.get(0);
        Driver driver = users.get(0).getDriver();
        driver.toggleIsActive();
        driverRepository.save(driver);
        user.updateIsActive();
        userRepository.save(user);
        return "viewAccount";
    }
}
