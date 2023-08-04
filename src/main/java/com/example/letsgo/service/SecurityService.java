package com.example.letsgo.service;

import com.example.letsgo.entities.User;
import com.example.letsgo.repositories.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
    @Autowired UserRepository userRepository;

    public HttpSession login(String usernameEmail, String password, HttpSession session) {
        session.setAttribute("ROLE", "Guest");
        session.removeAttribute("AUTH");
        User user = userRepository.findByUsernameAndPassword(usernameEmail, password);
        if (user == null) {
            user = userRepository.findByEmailAndPassword(usernameEmail, password);
                }
        if (user != null) {
            session.setAttribute("firstName", user.getFirstName());
            session.setAttribute("lastName", user.getLastName());
            session.setAttribute("fullName", user.getFullName());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("userStatus", user.getUserStatus());
            if (user.getIsActive()) {
                if (user.getRider().getIsActive()) {
                    session.setAttribute("riderId", user.getRider().getRiderId());
                    session.setAttribute("riderStatus", user.getRider().getRiderStatus());
                } else {
                    session.removeAttribute("riderId");
                    session.removeAttribute("riderStatus");
                }
                if (user.getDriver().getIsActive()) {
                    session.setAttribute("driverId", user.getDriver().getDriverId());
                    session.setAttribute("driverStatus", user.getDriver().getDriverStatus());
                } else {
                    session.removeAttribute("driverId");
                    session.removeAttribute("driverStatus");
                }
                if (user.getIsAdmin()) {
                    session.setAttribute("AUTH", "ADMIN");
                } else {
                    session.setAttribute("AUTH", "USER");
                }
                if (user.getIsAdmin()) {
                    session.setAttribute("ROLE", "Admin");
                } else if (user.getDriver().getDriverStatus().equals("Active")) {
                    session.setAttribute("ROLE", "Driver");
                } else if (user.getRider().getRiderStatus().equals("Active")) {
                    session.setAttribute("ROLE", "Rider");
                } else if (user.getDriver().getIsActive()) {
                    session.setAttribute("ROLE", "Driver");
                } else if (user.getRider().getIsActive()) {
                    session.setAttribute("ROLE", "Rider");
                } else {
                    session.setAttribute("ROLE", "User");
                }
            }
        } else {
            // remove all attributes upon failed login
            session.removeAttribute("firstName");
            session.removeAttribute("lastName");
            session.removeAttribute("fullName");
            session.removeAttribute("userId");
            session.removeAttribute("userStatus");
            session.removeAttribute("riderId");
            session.removeAttribute("riderStatus");
            session.removeAttribute("driverId");
            session.removeAttribute("driverStatus");
            session.removeAttribute("AUTH");
            // set role to guest so that the link logic function better
            session.setAttribute("ROLE", "Guest");

            // "admin" "admin" login bypass for demo purposes
            if (usernameEmail.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
                session.setAttribute("firstName", "Admin");
                session.setAttribute("lastName", "Admin");
                session.setAttribute("fullName", "Admin");
                session.setAttribute("AUTH", "ADMIN");
                session.setAttribute("ROLE", "Admin");
            }
            // Obviously for a real deployment this would be deleted, but it makes it easier to access the app,
            // especially if you want to test things out while the database has no users in it

        }
        // set homepage links
        if (session.getAttribute("ROLE").equals("Admin")) { session.setAttribute("redirect", "redirect:/admin/users"); }
        if (session.getAttribute("ROLE").equals("Driver")) { session.setAttribute("redirect", "redirect:/user/drivers/home_driver"); }
        if (session.getAttribute("ROLE").equals("Rider")) { session.setAttribute("redirect", "redirect:/user/riders/home_rider"); }
        if (session.getAttribute("ROLE").equals("Guest")) { session.setAttribute("redirect", "redirect:/user/login"); }
        return session;
    }


    public String login(String username, String password) {
        String status = "Guest";
        List<User> users = userRepository.findUsersByUsernameAndPassword(username, password);
        if (users.isEmpty()) {
            users = userRepository.findUsersByEmailAndPassword(username, password);
        } if (!users.isEmpty()) {
            if (users.get(0).isAdmin) {
                status = "Admin";
            }
            else if (users.get(0).getDriver().getIsActive()) {
                status = "Driver";
            }
            else if (users.get(0).getRider().getIsActive()) {
                status = "Rider";
            }
        }
        if (status == "Guest") {
            if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {
                status = "Admin";
            }
        return status;
        }
  
  
    public HttpSession logout(HttpSession session) {
        session.invalidate();
        return session;
    }
}
