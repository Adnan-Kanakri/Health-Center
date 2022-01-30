package HealthCenterApplication.com.example.HealthCenter.controller.admin;

import java.util.List;

import HealthCenterApplication.com.example.HealthCenter.Services.DoctorServices;
import HealthCenterApplication.com.example.HealthCenter.dao.DepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDao;
//import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.model.*;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminDoctorController {

    @Autowired
    private DoctorServices doctorServices;


    @PostMapping("/addDoctor")
    public ActionResult addDoctor(@RequestBody Doctor doctor) {
        return doctorServices.addDoctor(doctor);
    }

    @PostMapping("/linkDoctorWithDepartment")
    public ActionResult linkDoctorWithDepartment(@RequestBody DoctorDepartmentIdentity doctorDepartmentIdentity) {
        return doctorServices.linkDoctorWithDepartment(doctorDepartmentIdentity);
    }

    @PutMapping("/updateDoctor/{id}")
    public ActionResult updateDoctor(@PathVariable int id, @RequestBody Doctor doctor) {
        return doctorServices.updateDoctor(id, doctor);
    }

    @DeleteMapping("/deleteDoctor/{id}")
    public ActionResult deleteDoctor(@PathVariable int id) {
        return doctorServices.deleteDoctor(id);
    }

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

