package HealthCenterApplication.com.example.HealthCenter.controller.patient;

import HealthCenterApplication.com.example.HealthCenter.Services.HealthRecordServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientHealthRecordController {

    @Autowired
    private HealthRecordServices healthRecordServices;

    @GetMapping("/HealthRecordByPatientId/{id}")
    public ActionResult getHealthRecordByPatientId(@PathVariable int id) {
        return healthRecordServices.getHealthRecordByPatientId(id);
    }
}
