package HealthCenterApplication.com.example.HealthCenter.controller.doctor;

import HealthCenterApplication.com.example.HealthCenter.Services.AppointmentServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorAppointmentController {
    @Autowired
    private AppointmentServices appointmentServices;

    @PostMapping("/answerAnAppointment")
    private ActionResult answerAnAppointment(@RequestBody Map<String, ?> jsonBody) {
        return appointmentServices.answerAnAppointment(jsonBody);
    }

    @PostMapping("/closeAnAppointment")
    private ActionResult closeAnAppointment(@RequestBody Map<String, ?> jsonBody) {
        return appointmentServices.closeAnAppointment(jsonBody);
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
