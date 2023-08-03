package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Rider;
import com.example.letsgo.entities.User;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.UserRepository;
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
public class UsersController {

    @Autowired
    private UserRepository userRepository;
    private RiderRepository riderRepository;
    private DriverRepository driverRepository;
    public HttpSession httpSession;

    @GetMapping("/admin/users")
    public String users(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<User> users;
        if (keyId.isEmpty()) {
            users = userRepository.findAll();
        } else {
            Integer id = Integer.parseInt(keyId);
            users = userRepository.findUsersByUserId(id);
        }
        model.addAttribute("listUsers", users);
        return "/admin/users";
    }

    @GetMapping("/admin/users/createUser")
    public String createUser(Model model){
        model.addAttribute("user", new User());
        return "/admin/users/createUser";
    }

    @PostMapping("/admin/users/createUser")
    public String createUser(Model model, User user, BindingResult bindingResult,
                             ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "/admin/users/createUser";
        } else {
            if (user.getIsAdmin()) {user.setIsAdmin(false);}
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
            return "redirect:/admin/users";
        }
    }

    @GetMapping("/admin/users/editUser")
    public String editUser(Integer id, Model model) {
        User user = userRepository.findUsersByUserId(id).get(0);
        model.addAttribute("user", user);
        httpSession.setAttribute("section", "admin");
        return "/admin/users/editUser";
    }
    @PostMapping("/admin/users/editUser")
    public String editUser(User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/users/editUser";
        }
        userRepository.save(user);
        return "redirect:/admin/users";
    }

    @GetMapping("/admin/users/deleteUser")
    public String deleteUser(Integer id){
        userRepository.deleteById(id);
        return "redirect:/admin/users";
    }
}
