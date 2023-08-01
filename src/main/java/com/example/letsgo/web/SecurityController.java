package com.example.letsgo.web;

import com.example.letsgo.service.SecurityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SecurityController {
    @Autowired private SecurityService securityService;

    @PostMapping("/user/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        String status = securityService.login(username, password);
        session.setAttribute("status", status);
        if (session.getAttribute("status") == "Admin") { return "/admin/users"; }
        else if (session.getAttribute("status") == "User") { return "/user/riders/profile_rider"; }
        else { return "redirect:/user/login" ; }
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("status");
        return "redirect:/index" ;
    }
    @GetMapping("/user/logout")
    public String userLogout(HttpSession session) {
        session.removeAttribute("status");
        return "redirect:/index" ;
    }
    @GetMapping("/admin/logout")
    public String adminLogout(HttpSession session) {
        session.removeAttribute("status");
        return "redirect:/admin/" ;
    }
}
