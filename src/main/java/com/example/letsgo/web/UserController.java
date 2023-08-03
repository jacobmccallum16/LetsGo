package com.example.letsgo.web;

import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.UserRepository;
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
    public String registerDriver() {
        return "/user/drivers/register_driver";
    }

    @GetMapping("/user/riders/register_rider")
    public String registerRider() {
        return "/user/riders/register_rider";
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
