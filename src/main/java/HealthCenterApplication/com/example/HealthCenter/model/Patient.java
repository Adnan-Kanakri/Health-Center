package HealthCenterApplication.com.example.HealthCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "patient")
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
public class Patient {

    @Id
    @GeneratedValue
    private int id;
    private String first_name;
    private String last_name;
    private String gender;
    private String nationality;
    private String phone;
    private String address;
    private Date birthdate;
    private String username;
    private String password;

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointmentSet = new HashSet();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private HealthRecord record;

//    public Patient() {
//    }

    public Patient(int id, String first_name, String last_name, String gender, String nationality, String phone, String address, Date birthdate, String username, String password, Set<Appointment> appointmentSet, HealthRecord record) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
        this.username = username;
        this.password = password;
        this.appointmentSet = appointmentSet;
        this.record = record;
    }

    public Patient(int id, String first_name, String last_name, String gender, String nationality, String phone, String address, Date birthdate) {
        this.id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.gender = gender;
        this.nationality = nationality;
        this.phone = phone;
        this.address = address;
        this.birthdate = birthdate;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
}
