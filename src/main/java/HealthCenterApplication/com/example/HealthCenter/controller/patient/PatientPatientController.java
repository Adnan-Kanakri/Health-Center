package HealthCenterApplication.com.example.HealthCenter.controller.patient;

import HealthCenterApplication.com.example.HealthCenter.Services.PatientServices;
import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/patient")
public class PatientPatientController {

    ActionResult actionResult;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientServices patientServices;

    @PostMapping("/signup")
    public ActionResult addPatient(@RequestBody Patient patient) {
        return patientServices.addPatient(patient);
    }

    @PostMapping("/login")
    private ActionResult login(@RequestBody Map<String, ?> jsonBody) {
        return patientServices.login(jsonBody);
    }

}
