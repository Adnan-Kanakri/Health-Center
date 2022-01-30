package HealthCenterApplication.com.example.HealthCenter.model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class DoctorDepartmentIdentity implements Serializable {

    private int department_id;
    private int doctor_id;

    public DoctorDepartmentIdentity() {
    }

    public DoctorDepartmentIdentity(int department_id, int doctor_id) {
        this.department_id = department_id;
        this.doctor_id = doctor_id;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }
}

