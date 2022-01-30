package HealthCenterApplication.com.example.HealthCenter.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "doctor")
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Doctor implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;
    private String address;
    private Date birthdate;
    private String specialization;
    private String username;
    private String password;


    @OneToMany(mappedBy = "doctor")
    private Set<DoctorDepartment> doctorDepartment = new HashSet();

    @OneToMany(mappedBy = "doctor")
    private Set<Appointment> appointmentSet = new HashSet();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({@JoinColumn(name = "doctor_id"),
//            @JoinColumn(name = "department_id")})
//    private DoctorDepartment doctorDepartment;


    public Doctor(int id, String first_name, String last_name, String address, Date birthdate, String specialization, String username, String password, Set<DoctorDepartment> doctorDepartment, Set<Appointment> appointmentSet) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.birthdate = birthdate;
        this.specialization = specialization;
        this.username = username;
        this.password = password;
        this.doctorDepartment = doctorDepartment;
        this.appointmentSet = appointmentSet;
    }

    public Doctor(int id, String first_name, String last_name, String address, Date birthdate, String specialization) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.address = address;
        this.birthdate = birthdate;
        this.specialization = specialization;
//        this.doctorDepartment = doctorDepartment;
//        this.department_id = department_id;
//        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //
//    public Set<DoctorDepartment> getDoctorDepartment() {
//        return doctorDepartment;
//    }
//
//    public void setDoctorDepartment(Set<DoctorDepartment> doctorDepartment) {
//        this.doctorDepartment = doctorDepartment;
//    }
//        public Integer getDepartment_id() {
//        return department_id;
//    }
//
//    public void setDepartment_id(Integer department_id) {
//        this.department_id = department_id;
//    }
}