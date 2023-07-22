package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Route;
import com.example.letsgo.repositories.RouteRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class RoutesController {

    @Autowired
    private RouteRepository routeRepository;
    public HttpSession httpSession;

    @GetMapping("/admin/routes")
    public String routes(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<Route> routes;
        if (keyId.isEmpty()) {
            routes = routeRepository.findAll();
        } else {
            routes = routeRepository.findRoutesByRouteId(Integer.parseInt(keyId));
        }
        model.addAttribute("routes", routes);
        return "/admin/routes";
    }

    @GetMapping("/admin/routes/createRoute")
    public String createRoute(Model model){
        model.addAttribute("route", new Route());
        return "/admin/routes/createRoute";
    }
    @PostMapping("/admin/routes/createRoute")
    public String createRoute(Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/routes/createRoute";
        } else {
            routeRepository.save(route);
            return "redirect:/admin/routes";
        }
    }

    @GetMapping("/admin/routes/editRoute")
    public String editRoute(Integer id, Model model) {
        Route route = routeRepository.findRouteByRouteId(id);
        model.addAttribute("route", route);
        return "/admin/routes/editRoute";
    }
    @PostMapping("/admin/routes/editRoute")
    public String editRoute(Route route, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/routes/editRoute";
        }
        routeRepository.save(route);
        return "redirect:/admin/routes";
    }

    @GetMapping("/admin/routes/deleteRoute")
    public String deleteRoute(Integer id){
        routeRepository.deleteById(id);
        return "redirect:/admin/routes";
    }
}
