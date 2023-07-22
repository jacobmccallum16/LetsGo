package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Rider;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.UserRepository;
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
public class RidersController {

    @Autowired
    private UserRepository userRepository;
    private RiderRepository riderRepository;
    private DriverRepository driverRepository;
    public HttpSession httpSession;

    @GetMapping("/admin/riders")
    public String riders(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<Rider> riders;
        if (keyId.isEmpty()) {
            riders = riderRepository.findAll();
        } else {
            riders = riderRepository.findRiderByRiderId(Integer.parseInt(keyId));
        }
        for (int i = riders.size()-1; i >= 0; i--) {
            if (!riders.get(i).isActive && riders.get(i).tripsTaken.equals(0)) {
                riders.remove(i);
            }
        }
        model.addAttribute("riders", riders);
        return "/admin/riders";
    }

    @GetMapping("/admin/riders/editRider")
    public String editRider(Integer id, Model model) {
        Rider rider = riderRepository.findRiderByRiderId(id).get(0);
        model.addAttribute("rider", rider);
        return "/admin/riders/editRider";
    }
    @PostMapping("/admin/riders/editRider")
    public String editRider(Rider rider, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/riders/editRider";
        }
        riderRepository.save(rider);
        rider.updateStatus(rider.riderStatus);
        rider.updateSafetyScore();
        riderRepository.save(rider);
        return "redirect:/admin/riders";
    }


    @GetMapping("/admin/riders/riderStatus")
    public String riderStatus(Integer id, String status) {
        Rider rider = riderRepository.findRiderByRiderId(id).get(0);
        rider.riderStatus = status;
//        rider.updateStatus();
        riderRepository.save(rider);
        return "redirect:/admin/riders";
    }
}
