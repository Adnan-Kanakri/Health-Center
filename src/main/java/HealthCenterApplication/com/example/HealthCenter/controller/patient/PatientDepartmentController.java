package HealthCenterApplication.com.example.HealthCenter.controller.patient;

import HealthCenterApplication.com.example.HealthCenter.Services.DepartmentServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
public class PatientDepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @GetMapping("/getDepartments")
    public ActionResult getDepartments() {
        return departmentServices.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public ActionResult getDepartmentById(@PathVariable int id) {
        return departmentServices.getDepartmentById(id);
    }

}
