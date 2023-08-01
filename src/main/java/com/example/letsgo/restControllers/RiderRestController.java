package com.example.letsgo.restControllers;

import com.example.letsgo.entities.Rider;
import com.example.letsgo.service.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/riders/")
public class RiderRestController {

    @Autowired private RiderService riderService;

    @GetMapping("/getActiveRiders")
    public List<Rider> getActiveRiders() {
        List<Rider> activeRiders = riderService.getActiveRidersSortedByName();
        return activeRiders;
    }
}
