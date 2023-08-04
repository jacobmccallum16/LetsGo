package com.example.letsgo.web;

import com.example.letsgo.service.SecurityService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"fail"})
@Controller
public class SecurityController {
    @Autowired private SecurityService securityService;
    @Autowired public HttpSession httpSession;

    @PostMapping("/user/login")

//     public String login(@RequestParam String username, @RequestParam String password) {
//         httpSession = securityService.login(username, password, httpSession);
//         String redirect = httpSession.getAttribute("redirect").toString();
//         httpSession.removeAttribute("redirect");
//         return redirect;

    public String login(@RequestParam String username, @RequestParam String password, ModelMap mm, HttpSession session) {
        String status = securityService.login(username, password);
        session.setAttribute("status", status);
        if (session.getAttribute("status") == "Admin") { return "redirect:/admin"; }
        else if (session.getAttribute("status") == "Driver") {
            return "redirect:/user/drivers/home_driver";
        }
        else if (session.getAttribute("status") == "Rider") {
            return "redirect:/user/riders/home_rider";
        }
        else {
            mm.put("fail", 2);
            return "redirect:/user/login" ;
        }

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
}
