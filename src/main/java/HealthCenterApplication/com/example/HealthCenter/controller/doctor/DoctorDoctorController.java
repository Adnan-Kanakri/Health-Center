package HealthCenterApplication.com.example.HealthCenter.controller.doctor;

import HealthCenterApplication.com.example.HealthCenter.Services.DoctorServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorDoctorController {

    @Autowired
    private DoctorServices doctorServices;


    @PostMapping("/signup")
    public ActionResult addDoctor(@RequestBody Doctor doctor) {
        return doctorServices.addDoctor(doctor);
    }

    @PostMapping("/login")
    private ActionResult login(@RequestBody Map<String, ?> jsonBody) {
        return doctorServices.login(jsonBody);
    }
}
