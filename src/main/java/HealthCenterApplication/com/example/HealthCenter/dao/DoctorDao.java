package HealthCenterApplication.com.example.HealthCenter.dao;

import HealthCenterApplication.com.example.HealthCenter.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DoctorDao extends CrudRepository<Doctor, Integer> {
    public List<Doctor> findByDoctorDepartmentDepartmentId(int doctorDepartmentId);
    public Doctor findByUsername(String username);

//    Doctor findOne(int doctor_id);
//
//    void delete(int id);
}
