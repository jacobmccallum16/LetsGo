package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.entities.Route;
import com.example.letsgo.entities.Trip;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.RouteRepository;
import com.example.letsgo.repositories.TripRepository;
import com.example.letsgo.service.TripService;
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

    @Autowired private RouteRepository routeRepository;
    @Autowired private TripRepository tripRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private RiderRepository riderRepository;
    @Autowired private TripService tripService;
    public HttpSession httpSession;

    @GetMapping("/admin/trips")
    public String routes(Model model, @RequestParam(name="routeId",defaultValue = "") String routeId,
                         @RequestParam(name="driverId",defaultValue = "") String driverId,
                         @RequestParam(name="tripId",defaultValue = "") String tripId) {
        List<Trip> trips = tripService.getTrips(routeId, driverId, tripId);
        String title = tripService.getTripsTitle(routeId, driverId, tripId);
        model.addAttribute("trips", trips);
        model.addAttribute("title", title);
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
            return "/admin/trips/createTrip";
        } else {
            trip.calculateArrivalTime();
            tripRepository.save(trip);
            String redirect = "redirect:/admin/trips?routeId=" + trip.getRoute().routeId.toString();
            return redirect;
        }
    }

    @GetMapping("/admin/trips/editTrip")
    public String editTrip(Integer id, Model model) {
        Trip trip = tripRepository.findTripByTripId(id);
        model.addAttribute("trip", trip);
        List<Driver> drivers = tripService.getPotentialDriversSortedByName(id.toString());
        model.addAttribute("drivers", drivers);
        return "/admin/trips/editTrip";
    }
    @PostMapping("/admin/trips/editTrip")
    public String editTrip(Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/trips/editTrip";
        }
        tripService.processEditTripForm(trip);
        return "redirect:/admin/trips#tripId-" + trip.getTripId().toString();
    }

    @GetMapping("/admin/trips/calculateArrivalTime")
    public String calculateArrivalTime(Integer tripId) {
        Trip trip = tripRepository.findTripByTripId(tripId);
        trip.calculateArrivalTime();
        tripRepository.save(trip);
        return "redirect:/admin/trips";
    }

    @GetMapping("/admin/trips/deleteTrip")
    public String deleteTrip(Integer id){
        tripRepository.deleteById(id);
        return "redirect:/admin/trips";
    }

    @GetMapping("/admin/trips/tripDetails")
    public String getTripDetails(@RequestParam(name="tripId") String tripId, Model model) {
        model.addAttribute("trip", tripService.getTripByTripId(Integer.parseInt(tripId)));
        model.addAttribute("drivers", tripService.getDriverTripTransactionByTripId(Integer.parseInt(tripId)));
        model.addAttribute("riders", tripService.getRiderTripTransactionsByTripId(Integer.parseInt(tripId)));
        return "/admin/trips/tripDetails";
    }

//    @GetMapping("/admin/trips/addRiders}")
//    public String addRiders(@RequestParam(name="tripId") String tripId, Model model) {
//        Trip trip = tripRepository.findTripByTripId(Integer.parseInt(tripId));
//        List<Rider> activeRiders = riderRepository.findActiveRidersSortedByName();
//        model.addAttribute("trip", trip);
//        model.addAttribute("activeRiders", activeRiders);
//        return "/admin/trips/addRiders";
//    }


}
