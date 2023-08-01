package com.example.letsgo.service;

import com.example.letsgo.entities.Rider;
import com.example.letsgo.repositories.RiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RiderService {
    @Autowired private RiderRepository riderRepository;

    public List<Rider> getActiveRidersSortedByName() {
        return riderRepository.findActiveRidersSortedByName();
    }
}
