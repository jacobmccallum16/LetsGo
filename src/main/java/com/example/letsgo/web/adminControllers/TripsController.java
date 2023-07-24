package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Route;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.RouteRepository;
import com.example.letsgo.repositories.TripRepository;
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
public class TripsController {

    @Autowired
    private RouteRepository routeRepository;
    private TripRepository tripRepository;
    public HttpSession httpSession;

    @GetMapping("/admin/trips")
    public String routes(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<Trip> trips;
        if (keyId.isEmpty()) {
            trips = tripRepository.findAll();
        } else {
            trips = tripRepository.findTripsByTripId(Integer.parseInt(keyId));
        }
        model.addAttribute("trips", trips);
        return "/admin/trips";
    }

    @GetMapping("/admin/trips/createTrip")
    public String createTrip(Integer routeId, Model model){
        Route route = routeRepository.findRouteByRouteId(routeId);
        model.addAttribute("trip", new Trip(route));
        return "/admin/trips/createTrip";
    }
    @PostMapping("/admin/trips/createTrip")
    public String createTrip(Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/trips/createTrips";
        } else {
            tripRepository.save(trip);
            return "redirect:/admin/trips";
        }
    }

    @GetMapping("/admin/trips/editTrip")
    public String editTrip(Integer id, Model model) {
        Trip trip = tripRepository.findTripByTripId(id);
        model.addAttribute("trip", trip);
        return "/admin/trips/editTrip";
    }
    @PostMapping("/admin/trips/editTrip")
    public String editTrip(Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/trips/editTrip";
        }
        Route parentRoute = trip.route;
        parentRoute.trips.add(trip);
        routeRepository.save(parentRoute);
        return "redirect:/admin/trips";
    }

    @GetMapping("/admin/trips/deleteTrip")
    public String deleteTrip(Integer id){
        tripRepository.deleteById(id);
        return "redirect:/admin/trips";
    }
}
