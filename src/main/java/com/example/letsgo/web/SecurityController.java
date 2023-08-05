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
    @Autowired public HttpSession httpSession;

    @PostMapping("/login")
     public String login(@RequestParam String username, @RequestParam String password) {
        httpSession = securityService.login(username, password, httpSession);
        String redirect = httpSession.getAttribute("redirect").toString();
        httpSession.removeAttribute("redirect");
        return redirect;
    }

    @GetMapping("/logout")
    public String logout() {
        httpSession = securityService.logout(httpSession);
        return "redirect:/index" ;
    }
    @GetMapping("/user/logout")
    public String userLogout() {
        httpSession = securityService.logout(httpSession);
        return "redirect:/index" ;
    }
    @GetMapping("/admin/logout")
    public String adminLogout() {
        httpSession = securityService.logout(httpSession);
        return "redirect:/admin" ;
    }

    @GetMapping("/user/switchToRiderAccount")
    public String switchToRiderAccount() {
        securityService.switchToRiderAccount(httpSession);
        return "redirect:/user/riders/profile_rider";
    }
    @GetMapping("/user/switchToDriverAccount")
    public String switchToDriverAccount() {
        securityService.switchToDriverAccount(httpSession);
        return "redirect:/user/drivers/profile_driver";
    }
    @GetMapping("/user/switchToAdminAccount")
    public String switchToAdminAccount() {
        securityService.switchToAdminAccount(httpSession);
        return "redirect:/admin";
    }
}
