package com.example.letsgo.web.adminControllers;

import com.example.letsgo.entities.Driver;
import com.example.letsgo.repositories.DriverRepository;
import com.example.letsgo.repositories.RiderRepository;
import com.example.letsgo.repositories.UserRepository;
import com.example.letsgo.service.DriverService;
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

    @Autowired private UserRepository userRepository;
    @Autowired private RiderRepository riderRepository;
    @Autowired private DriverRepository driverRepository;
    @Autowired private DriverService driverService;
    @Autowired public HttpSession httpSession;

    @GetMapping("/admin/drivers")
    public String drivers(Model model, @RequestParam(name="driverId",defaultValue = "") String driverId) {
        List<Driver> drivers = driverService.getDrivers(driverId);
        model.addAttribute("drivers", drivers);
        return "/admin/drivers";
    }

    @GetMapping("/admin/drivers/editDriver")
    public String editDriver(Integer id, Model model) {
        Driver driver = driverService.getDriver(id);
        model.addAttribute("driver", driver);
        return "/admin/drivers/editDriver";
    }
    @PostMapping("/admin/drivers/editDriver")
    public String editDriver(Driver driver, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/drivers/editDriver";
        }
        driverService.updateDriver(driver);
        return "redirect:/admin/drivers";
    }

    @GetMapping("/admin/drivers/driverStatus")
    public String driverStatus(Integer id, String status) {
        driverService.setDriverStatus(id, status);
        return "redirect:/admin/drivers";
    }
}
