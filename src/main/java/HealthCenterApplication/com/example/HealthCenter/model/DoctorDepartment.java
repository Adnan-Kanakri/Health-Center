package HealthCenterApplication.com.example.HealthCenter.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.print.Doc;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor_department")
@NoArgsConstructor
@ToString
public class DoctorDepartment implements Serializable {


    @EmbeddedId
    private DoctorDepartmentIdentity doctorDepartmentIdentity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false, insertable = false, updatable = false)
    private Doctor doctor;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", nullable = false, insertable = false, updatable = false)
    private Department department;



    public DoctorDepartment(DoctorDepartmentIdentity doctorDepartmentIdentity, Doctor doctor, Department department) {
        this.doctorDepartmentIdentity = doctorDepartmentIdentity;
        this.doctor = doctor;
        this.department = department;
    }

    public DoctorDepartmentIdentity getDoctorDepartmentIdentity() {
        return doctorDepartmentIdentity;
    }

    public void setDoctorDepartmentIdentity(DoctorDepartmentIdentity doctorDepartmentIdentity) {
        this.doctorDepartmentIdentity = doctorDepartmentIdentity;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    //    @OneToMany(mappedBy = "doctorDepartment")
//    private Set<Doctor> doctorSet = new HashSet();
//
//    @OneToMany(mappedBy = "departmentDoctor")
//    private Set<Department> departmentSet = new HashSet();

}
