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
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Timestamp;

@SessionAttributes({"register"})
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
        return "/user/landing";
    }

    @GetMapping("/user/login")
    public String login() {
        return "/user/login";
    }

    @GetMapping("/user/forgot-password")
    public String forgotPassword() {
        return "/user/forgot-password";
    }

    @GetMapping("/user/drivers/register_driver")
    public String registerDriver(Model model) {
        model.addAttribute("user", new User());
        return "/user/drivers/register_driver";
    }

    @PostMapping("/user/drivers/register_driver")
    public String registerDriver(Model model, User user, BindingResult bindingResult,
                           ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "/user/drivers/register_driver";
        } else {
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
            user.setIsActive(true);
            user.setUserStatus("Active");
            driver.setIsActive(true);
            driver.setDriverStatus("Active");
            driver.setIsActive(true);
            userRepository.save(user);
            driverRepository.save(driver);
            riderRepository.save(rider);
            mm.put("register", 1);
            return "redirect:/user/login";
        }
    }

    @GetMapping("/user/riders/register_rider")
    public String registerRider(Model model) {
        model.addAttribute("user", new User());
        return "/user/riders/register_rider";
    }

    @PostMapping("/user/riders/register_rider")
    public String registerRider(Model model, User user, BindingResult bindingResult,
                                 ModelMap mm, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "/user/riders/register_rider";
        } else {
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
            user.setIsActive(true);
            user.setUserStatus("Active");
            rider.setIsActive(true);
            rider.setRiderStatus("Active");
            userRepository.save(user);
            driverRepository.save(driver);
            riderRepository.save(rider);
            mm.put("register", 1);
            return "redirect:/user/login";
        }
    }

    @GetMapping("/user/riders/home_rider")
    public String homeRider() {
        return "/user/riders/home_rider";
    }

    @GetMapping("/user/riders/profile_rider")
    public String profileRider() {
        return "/user/riders/profile_rider";
    }

    @GetMapping("/user/riders/request_rider")
    public String requestRider() {
        return "/user/riders/request_rider";
    }

    @GetMapping("/user/riders/checkout_rider")
    public String checkoutRider() {
        return "/user/riders/checkout_rider";
    }

    @GetMapping("/user/riders/my_trips_rider")
    public String myTripsRider() {
        return "/user/riders/my_trips_rider";
    }

    @GetMapping("/user/riders/settings_rider")
    public String settingsRider() {
        return "/user/riders/settings_rider";
    }

    @GetMapping("/user/riders/payment_method_rider")
    public String paymentMethodRider() {
        return "/user/riders/payment_method_rider";
    }

    @GetMapping("/user/drivers/home_driver")
    public String homeDriver() {
        return "/user/drivers/home_driver";
    }

    @GetMapping("/user/drivers/profile_driver")
    public String profileDriver() {
        return "/user/drivers/profile_driver";
    }

    @GetMapping("/user/drivers/request_driver")
    public String requestDriver() {
        return "/user/drivers/request_driver";
    }

    @GetMapping("/user/drivers/my_trips_driver")
    public String myTripsDriver() {
        return "/user/drivers/my_trips_driver";
    }

    @GetMapping("/user/drivers/settings_driver")
    public String settingsDriver() {
        return "/user/drivers/settings_driver";
    }

    @GetMapping("/user/drivers/payment_method_driver")
    public String paymentMethodDriver() {
        return "/user/drivers/payment_method_driver";
    }

}
