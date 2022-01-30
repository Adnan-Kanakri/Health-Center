package HealthCenterApplication.com.example.HealthCenter.controller.doctor;

import HealthCenterApplication.com.example.HealthCenter.Services.HealthRecordServices;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.HealthRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorHealthRecordController {

    @Autowired
    private HealthRecordServices healthRecordServices;

    @PostMapping("/addHealthRecord")
    private ActionResult addHealthRecord(@RequestBody HealthRecord healthRecord) {
        return healthRecordServices.addHealthRecord(healthRecord);
    }

    @GetMapping("/HealthRecordList")
    public ActionResult getHealthRecordList() {
        return healthRecordServices.getHealthRecordList();
    }

    @GetMapping("/HealthRecordByPatientId/{id}")
    public ActionResult getHealthRecordByPatientId(@PathVariable int id) {
        return healthRecordServices.getHealthRecordByPatientId(id);
    }


}
