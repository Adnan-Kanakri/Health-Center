package HealthCenterApplication.com.example.HealthCenter.dao;

import HealthCenterApplication.com.example.HealthCenter.model.Appointment;
import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AppointmentDao extends CrudRepository<Appointment, Integer> {
    public List<Appointment> findByDoctorId(int doctorId);
    public List<Appointment> findByPatientId(int patientId);
}
