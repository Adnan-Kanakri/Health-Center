package HealthCenterApplication.com.example.HealthCenter.Services;

import HealthCenterApplication.com.example.HealthCenter.dao.AppointmentDao;
import HealthCenterApplication.com.example.HealthCenter.dao.DoctorDao;
import HealthCenterApplication.com.example.HealthCenter.dao.PatientDao;
import HealthCenterApplication.com.example.HealthCenter.model.ActionResult;
import HealthCenterApplication.com.example.HealthCenter.model.Appointment;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AppointmentServices {

    private ActionResult actionResult;

    @Autowired
    private AppointmentDao appointmentDao;

    @Autowired
    private DoctorDao doctorDao;

    @Autowired
    private PatientDao patientDao;

    public ActionResult bookAnAppointment(Map<String, ?> jsonBody) {
        try {
            String insDate = (String) jsonBody.get("insert_date");
            Date insertDate = new SimpleDateFormat("yyyy-mm-dd").parse(insDate);
            String description = (String)jsonBody.get("description");
            int priority = (Integer) jsonBody.get("priority");
            String status = (String) jsonBody.get("status");
            int patientId = (Integer) jsonBody.get("patientId");
            int doctorId = (Integer) jsonBody.get("doctorId");
//            String startDate = (String) jsonBody.get("start_date");
//            Date start_date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(startDate);
//            String endDate = (String) jsonBody.get("start_date");
//            Date end_date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(endDate);
//            double cost = (Double) jsonBody.get("cost");


            Doctor doctor = doctorDao.findOne(doctorId);
            if (doctor == null) {
                return new ActionResult(0, "Doctor is not found", null);
            }
            Patient patient = patientDao.findOne(patientId);
            if (patient == null) {
                return new ActionResult(0, "Patient is not found", null);
            }

            Appointment appointment = new Appointment(insertDate, description, priority, status, doctor, patient);

            appointmentDao.save(appointment);
            actionResult = new ActionResult(0, "Success", appointment);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult answerAnAppointment(Map<String, ?> jsonBody) {
        try {
            int appointmentId = (Integer) jsonBody.get("id");
            String status = (String) jsonBody.get("status");

            Appointment appointment = appointmentDao.findOne(appointmentId);
            if(appointment == null){
                return new ActionResult(0, "Appointment is not found", null);
            }

            appointment.setStatus(status);
            appointmentDao.save(appointment);
            actionResult = new ActionResult(0, "Success", appointment);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult closeAnAppointment(Map<String, ?> jsonBody) {
        try {
            int appointmentId = (Integer) jsonBody.get("id");
            String status = "closed";
            String startDate = (String) jsonBody.get("start_date");
            Date start_date = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(startDate);
            Date end_date = Calendar.getInstance().getTime();//new SimpleDateFormat("yyyy-mm-dd HH:mm:ss").parse(endDate);
            double cost = (Double) jsonBody.get("cost");

            Appointment appointment = appointmentDao.findOne(appointmentId);
            if(appointment == null){
                return new ActionResult(0, "Appointment is not found", null);
            }

            appointment.setStatus(status);
            appointment.setStart_date(start_date);
            appointment.setEnd_date(end_date);
            appointment.setCost(cost);
            appointmentDao.save(appointment);
            actionResult = new ActionResult(0, "Success", appointment);
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult deleteAnAppointment(int id) {
        try {
            if (appointmentDao.findOne(id) != null) {
                appointmentDao.delete(id);
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

    public ActionResult getAppointmentsByDoctorId(int doctorId) {
        try {
            List<Appointment> appointmentList = (List<Appointment>) appointmentDao.findByDoctorId(doctorId);
            if (!appointmentList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", appointmentList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getAppointmentsByPatientId(int patientId) {
        try {
            List<Appointment> appointmentList = (List<Appointment>) appointmentDao.findByPatientId(patientId);
            if (!appointmentList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", appointmentList);
            } else {
                actionResult = new ActionResult(0, "No data found", "");
            }
            return actionResult;
        } catch (Exception ex) {
            actionResult = new ActionResult(-99, ex.getMessage(), null);
            return actionResult;
        }
    }

    public ActionResult getAppointments() {
        try {
            List<Appointment> appointmentList = (List<Appointment>) appointmentDao.findAll();
            if (!appointmentList.isEmpty()) {
                actionResult = new ActionResult(0, "Success", appointmentList);
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
