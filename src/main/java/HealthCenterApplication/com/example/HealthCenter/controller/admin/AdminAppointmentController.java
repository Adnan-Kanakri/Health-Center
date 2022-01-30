package HealthCenterApplication.com.example.HealthCenter.controller.admin;

import HealthCenterApplication.com.example.HealthCenter.Services.AppointmentServices;
import HealthCenterApplication.com.example.HealthCenter.dao.AppointmentDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDao;
import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/admin")
public class AdminAppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

//    @PostMapping("/bookAnAppointment")
//    private ActionResult bookAnAppointment(@RequestBody Map<String, ?> jsonBody) {
//        return appointmentServices.bookAnAppointment(jsonBody);
//    }

    @GetMapping("/getAppointmentsByDoctorId/{doctorId}")
    public ActionResult getAppointmentsByDoctorId(@PathVariable int doctorId) {
        return appointmentServices.getAppointmentsByDoctorId(doctorId);
    }

    @GetMapping("/getAppointmentsByPatientId/{patientId}")
    public ActionResult getAppointmentsByPatientId(@PathVariable int patientId) {
        return appointmentServices.getAppointmentsByPatientId(patientId);
    }

    @GetMapping("/getAppointments")
    public ActionResult getAppointments() {
        return appointmentServices.getAppointments();
    }
}
