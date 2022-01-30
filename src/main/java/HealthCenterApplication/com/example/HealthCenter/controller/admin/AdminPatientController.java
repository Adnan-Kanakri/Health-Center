package HealthCenterApplication.com.example.HealthCenter.controller.admin;

import HealthCenterApplication.com.example.HealthCenter.Services.PatientServices;
import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminPatientController {
    ActionResult actionResult;

    @Autowired
    private PatientDao patientDao;

    @Autowired
    private PatientServices patientServices;

    @PostMapping("/addPatient")
    public ActionResult addPatient(@RequestBody Patient patient) {
        return patientServices.addPatient(patient);
    }

    @PutMapping("/updatePatient/{id}")
    public ActionResult updatePatient(@PathVariable int id, @RequestBody Patient patient) {
        return patientServices.updatePatient(id, patient);
    }

    @DeleteMapping("/deletePatient/{id}")
    public ActionResult deletePatient(@PathVariable int id) {
        return patientServices.deletePatient(id);
    }

    @GetMapping("/getPatients")
    public ActionResult getPatients() {
        return patientServices.getPatients();
    }

    @GetMapping("/patients/{id}")
    public ActionResult getPatientById(@PathVariable int id) {
        return patientServices.getPatientById(id);
    }
}