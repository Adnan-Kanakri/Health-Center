package HealthCenterApplication.com.example.HealthCenter.dao;

import HealthCenterApplication.com.example.HealthCenter.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;


public interface DepartmentDao  extends CrudRepository<Department, Integer> {

//    Department findOne(int id);
//
//    void delete(int id);
}
