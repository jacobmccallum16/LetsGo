package com.example.letsgov1.web.adminControllers;

import com.example.letsgov1.entities.Driver;
import com.example.letsgov1.repositories.DriverRepository;
import com.example.letsgov1.repositories.RiderRepository;
import com.example.letsgov1.repositories.UserRepository;
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
public class DriversController {

    @Autowired
    private UserRepository userRepository;
    private RiderRepository riderRepository;
    private DriverRepository driverRepository;
    public HttpSession httpSession;

    @GetMapping("/admin/drivers")
    public String drivers(Model model, @RequestParam(name="keyId",defaultValue = "") String keyId) {
        List<Driver> drivers;
        if (keyId.isEmpty()) {
            drivers = driverRepository.findAll();
        } else {
            drivers = driverRepository.findDriverByDriverId(Integer.parseInt(keyId));
        }
        for (int i = drivers.size()-1; i >= 0; i--) {
            if (!drivers.get(i).isActive) {
                drivers.remove(i);
            }
        }
        model.addAttribute("drivers", drivers);
        return "/admin/drivers";
    }

    @GetMapping("/admin/drivers/editDriver")
    public String editDriver(Integer id, Model model) {
        Driver driver = driverRepository.findDriverByDriverId(id).get(0);
        model.addAttribute("driver", driver);
        return "/admin/drivers/editDriver";
    }
    @PostMapping("/admin/drivers/editDriver")
    public String editDriver(Driver driver, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/drivers/editDriver";
        }
        driver.updateStatus();
        driver.updateSafetyScore();
        driverRepository.save(driver);
        return "redirect:/admin/drivers";
    }

    @GetMapping("/admin/drivers/driverStatus")
    public String driverStatus(Integer id, String status) {
        Driver driver = driverRepository.findDriverByDriverId(id).get(0);
        driver.driverStatus = status;
//        driver.updateStatus();
        driverRepository.save(driver);
        return "redirect:/admin/drivers";
    }
}
