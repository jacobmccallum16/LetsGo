package com.example.letsgo.restControllers;

import com.example.letsgo.entities.*;
import com.example.letsgo.service.TripTransactionService;
import com.example.letsgo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserRestController {
    @Autowired private UserService userService;
    @Autowired private TripTransactionService tripTransactionService;

    @GetMapping("/{userId}/getUser")
    public User getUserDetails(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }
    @GetMapping("/driver/{driverId}/getDriver")
    public Driver getDriverDetails(@PathVariable Integer driverId) {
        return userService.getDriver(driverId);
    }
    @GetMapping("/driver/{driverId}/getTripTransactions")
    public List<DriverTripTransaction> getDriverTripTransactions(@PathVariable Integer driverId) {
        return userService.getDriverTripTransactions(driverId);
    }
    @GetMapping("/rider/{riderId}/getRider")
    public Rider getRiderDetails(@PathVariable Integer riderId) {
        return userService.getRider(riderId);
    }
    @GetMapping("/rider/{riderId}/getTripTransactions")
    public List<RiderTripTransaction> getRiderTripTransactions(@PathVariable Integer riderId) {
        return userService.getRiderTripTransactions(riderId);
    }

}
