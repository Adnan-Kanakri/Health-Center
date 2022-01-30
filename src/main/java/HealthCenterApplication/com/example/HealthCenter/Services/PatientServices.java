package HealthCenterApplication.com.example.HealthCenter.Services;

import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class PatientServices {
    ActionResult actionResult;

    @Autowired
    private PatientDao patientDao;

    public ActionResult addPatient(Patient patient) {
        try {
            patientDao.save(patient);
            actionResult = new ActionResult(0, "Success", patient);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult login(Map<String, ?> jsonBody) {
        try {
            String username = (String) jsonBody.get("username");
            String password = (String) jsonBody.get("password");


            Patient patient = patientDao.findByUsername(username);
            if(patient == null){
                return new ActionResult(0, "Patient is not found", null);
            }

            if(!password.equals(patient.getPassword())){
                return new ActionResult(0, "Password is not correct", null);
            }
            actionResult = new ActionResult(0, "Success", patient);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult updatePatient(int id, Patient patient) {
        try {
            if (patientDao.findOne(id) != null) {
                patient.setId(id);
                patientDao.save(patient);
                actionResult = new ActionResult(0, "Success", patient);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult deletePatient(int id) {
        try {
            if (patientDao.findOne(id) != null) {
                patientDao.delete(id);
                actionResult = new ActionResult(0, "Success", "");
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getPatients() {
        try {
            List<Patient> patientList = (List<Patient>) patientDao.findAll();
            if (!patientList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", patientList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getPatientById(int id) {
        try {
            Patient patient = patientDao.findOne(id);
            if (patient != null) {
                actionResult = new ActionResult(0, "Success", patient);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }
}
