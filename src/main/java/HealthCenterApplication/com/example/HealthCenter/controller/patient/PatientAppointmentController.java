package HealthCenterApplication.com.example.HealthCenter.controller.patient;

import HealthCenterApplication.com.example.HealthCenter.Services.AppointmentServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/patient")
public class PatientAppointmentController {

    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping("/bookAnAppointment")
    private ActionResult bookAnAppointment(@RequestBody Map<String, ?> jsonBody) {
        return appointmentServices.bookAnAppointment(jsonBody);
    }

    @DeleteMapping("/deleteAppointment/{id}")
    public ActionResult deleteAppointment(@PathVariable int id) {
        return appointmentServices.deleteAnAppointment(id);
    }

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
