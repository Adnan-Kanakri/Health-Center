package HealthCenterApplication.com.example.HealthCenter.dao;

import HealthCenterApplication.com.example.HealthCenter.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


public interface PatientDao extends CrudRepository<Patient, Integer> {

    public Patient findByUsername(String username);

}
