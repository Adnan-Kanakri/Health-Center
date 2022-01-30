package HealthCenterApplication.com.example.HealthCenter.dao;

import HealthCenterApplication.com.example.HealthCenter.model.HealthRecord;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HealthRecordDao extends CrudRepository<HealthRecord, Integer> {
//    public List<HealthRecord> findByAppointmentId(int appointmentId);
    public HealthRecord findByPatientId(int patientId);
}
