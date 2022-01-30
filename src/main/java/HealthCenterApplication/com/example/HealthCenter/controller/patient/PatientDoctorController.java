package HealthCenterApplication.com.example.HealthCenter.controller.patient;


import HealthCenterApplication.com.example.HealthCenter.Services.DoctorServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientDoctorController {

    @Autowired
    private DoctorServices doctorServices;

    @GetMapping("/getDoctors")
    public ActionResult getDoctors() {
        return doctorServices.getDoctors();
    }

    @GetMapping("/getDoctorsByDepartmentId/{id}")
    public ActionResult getDoctorsByDepartmentId(@PathVariable int id) {
        return doctorServices.getDoctorsByDepartmentId(id);
    }

    @GetMapping("/doctors/{id}")
    public ActionResult getDoctorById(@PathVariable int id) {
        return doctorServices.getDoctorById(id);
    }
}
