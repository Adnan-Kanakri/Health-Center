package HealthCenterApplication.com.example.HealthCenter.dao;

        import HealthCenterApplication.com.example.HealthCenter.model.DoctorDepartment;
        import HealthCenterApplication.com.example.HealthCenter.model.DoctorDepartmentIdentity;
        import org.springframework.data.repository.CrudRepository;
        //import org.springframework.stereotype.Repository;

public interface DoctorDepartmentDao extends CrudRepository<DoctorDepartment, DoctorDepartmentIdentity> {
//    void save(DoctorDepartmentIdentity doctorDepartmentIdentity);
}
