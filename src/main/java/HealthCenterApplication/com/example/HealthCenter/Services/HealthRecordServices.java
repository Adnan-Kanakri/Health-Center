package HealthCenterApplication.com.example.HealthCenter.Services;

import HealthCenterApplication.com.example.HealthCenter.dao.HealthRecordDao;
import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import HealthCenterApplication.com.example.HealthCenter.model.HealthRecord;
import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthRecordServices {

    ActionResult actionResult;

    @Autowired
    private HealthRecordDao healthRecordDao;

    public ActionResult addHealthRecord(HealthRecord healthRecord) {
        try {
            healthRecordDao.save(healthRecord);
            actionResult = new ActionResult(0, "Success", healthRecord);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getHealthRecordList() {
        try {
            List<HealthRecord> healthRecordList = (List<HealthRecord>) healthRecordDao.findAll();
            if (!healthRecordList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", healthRecordList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getHealthRecordByPatientId(int id) {
        try {
            HealthRecord healthRecord = (HealthRecord) healthRecordDao.findByPatientId(id);
            if (healthRecord != null) {
                actionResult = new ActionResult(0, "Success", healthRecord);
            } else {
                actionResult = new ActionResult(0, "No Health Record created for the selected Patient yet", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }


}
