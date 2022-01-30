package HealthCenterApplication.com.example.HealthCenter.controller.admin;


import HealthCenterApplication.com.example.HealthCenter.Services.DepartmentServices;
import HealthCenterApplication.com.example.HealthCenter.dao.DepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Department;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminDepartmentController {

    @Autowired
    private DepartmentServices departmentServices;

    @PostMapping("/addDepartment")
    public ActionResult addDepartment(@RequestBody Department department) {
        return departmentServices.addDepartment(department);
    }

    @PutMapping("/updateDepartment/{id}")
    public ActionResult updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentServices.updateDepartment(id, department);
    }

    @DeleteMapping("/deleteDepartment/{id}")
    public ActionResult deleteDepartment(@PathVariable int id) {
        return departmentServices.deleteDepartment(id);
    }

    @GetMapping("/getDepartments")
    public ActionResult getDepartments() {
        return departmentServices.getDepartments();
    }

    @GetMapping("/departments/{id}")
    public ActionResult getDepartmentById(@PathVariable int id) {
        return departmentServices.getDepartmentById(id);
    }

}
