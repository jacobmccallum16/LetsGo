package com.example.letsgo.web;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
            return "redirect:/admin/users";
    }
    @GetMapping("/admin/")
    public String adminHome2() {
        return "redirect:/admin/users";
    }
    @GetMapping("/admin/viewAccount")
    public String adminViewAccount(Integer id, Model model) {
        User user = userRepository.findUserByUserId(id);
        model.addAttribute("user", user);
        model.addAttribute("rider", user.getRider());
        model.addAttribute("driver", user.getDriver());
        httpSession.setAttribute("section", "admin");
        httpSession.setAttribute("page", "viewAccount");
        return "/admin/viewAccount";
    }
    @GetMapping("/admin/activateRider")
    public String activateRider(Integer id, Model model) {
        List<User> users = userRepository.findUsersByUserId(id);
        model.addAttribute("users", users);
        User user = users.get(0);
        Rider rider = users.get(0).getRider();
        rider.toggleIsActive();
        riderRepository.save(rider);
        user.updateIsActive();
        userRepository.save(user);
        return "/admin/viewAccount";
    }
    @GetMapping("/admin/activateDriver")
    public String activateDriver(Integer id, Model model) {
        List<User> users = userRepository.findUsersByUserId(id);
        model.addAttribute("users", users);
        User user = users.get(0);
        Driver driver = users.get(0).getDriver();
        driver.toggleIsActive();
        driverRepository.save(driver);
        user.updateIsActive();
        userRepository.save(user);
        return "/admin/viewAccount";
    }

}
