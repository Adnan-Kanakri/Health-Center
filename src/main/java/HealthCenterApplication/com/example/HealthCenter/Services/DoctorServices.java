package HealthCenterApplication.com.example.HealthCenter.Services;

import HealthCenterApplication.com.example.HealthCenter.dao.DepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDepartmentDao;
import HealthCenterApplication.com.example.HealthCenter.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Service
public class DoctorServices {

    ActionResult actionResult;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private DoctorDepartmentDao doctorDepartmentDao;

    public ActionResult addDoctor(Doctor doctor) {
        try {
            doctorDao.save(doctor);
            actionResult = new ActionResult(0, "Success", doctor);
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


            Doctor doctor = doctorDao.findByUsername(username);
            if(doctor == null){
                return new ActionResult(0, "Doctor is not found", null);
            }

            if(!password.equals(doctor.getPassword())){
                return new ActionResult(0, "Password is not correct", null);
            }
            actionResult = new ActionResult(0, "Success", doctor);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult linkDoctorWithDepartment(DoctorDepartmentIdentity doctorDepartmentIdentity) {
        try {
            Doctor doctor = doctorDao.findOne(doctorDepartmentIdentity.getDoctor_id());
            Department department = departmentDao.findOne(doctorDepartmentIdentity.getDepartment_id());
            DoctorDepartment doctorDepartment = new DoctorDepartment(doctorDepartmentIdentity,doctor,department);
            doctorDepartmentDao.save(doctorDepartment);
            actionResult = new ActionResult(0, "Success", doctorDepartment);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult updateDoctor(int id, Doctor doctor) {
        try {
            if (doctorDao.findOne(id) != null) {
                doctor.setId(id);
                doctorDao.save(doctor);
                actionResult = new ActionResult(0, "Success", doctor);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult deleteDoctor(int id) {
        try {
            if (doctorDao.findOne(id) != null) {
                doctorDao.delete(id);
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

    public ActionResult getDoctors() {
        try {
            List<Doctor> doctorList = (List<Doctor>) doctorDao.findAll();
            if (!doctorList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", doctorList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getDoctorsByDepartmentId(int id) {
        try {
            if (departmentDao.findOne(id) != null) {
                List<Doctor> doctorList = (List<Doctor>) doctorDao.findByDoctorDepartmentDepartmentId(id);
//                doctorDepartmentDao.findAll()
//                System.out.println("Alaa: " + doctorList.get(0).getId());
                if (!doctorList.isEmpty()) {
                    actionResult = new ActionResult(0, "Success", doctorList);
                } else {
                    actionResult = new ActionResult(0, "No doctors inside the selected department", "");
                }
            } else {
                actionResult = new ActionResult(0, "No department found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getDoctorById(int id) {
        try {
            Doctor doctor = doctorDao.findOne(id);
            if (doctor != null) {
                actionResult = new ActionResult(0, "Success", doctor);
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
