package HealthCenterApplication.com.example.HealthCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "appointment")
@JsonIgnoreProperties(value = {"handler", "hibernateLazyInitializer", "fieldHandler"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Appointment implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private Date insert_date;
    private String description;
    private int priority;
    private String status;
    @Column(name = "start_date", nullable = true)
    private Date start_date;
    @Column(name = "end_date", nullable = true)
    private Date end_date;
    @Column(name = "cost", nullable = true)
    private Double cost;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;


    public Appointment() {
    }

    public Appointment(Date insertDate, String description, int priority, String status, Date start_date, Date end_date, double cost, Doctor doctor, Patient patient) {
        this.insert_date = insertDate;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.cost = cost;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Appointment(int id, Date insert_date, String description, int priority, String status) {
        this.id = id;
        this.insert_date = insert_date;
        this.description = description;
        this.priority = priority;
        this.status = status;
    }

    public Appointment(int id, Date insert_date, String description, int priority, String status, Date start_date, Date end_date, double cost, Doctor doctor, Patient patient) {
        this.id = id;
        this.insert_date = insert_date;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.cost = cost;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Appointment(Date insert_date, String description, int priority, String status, Doctor doctor, Patient patient) {
        this.insert_date = insert_date;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }

    public Appointment(int id, Date insert_date, String description, int priority, String status, Doctor doctor, Patient patient) {
        this.id = id;
        this.insert_date = insert_date;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.doctor = doctor;
        this.patient = patient;
    }

//    public Appointment(int id, Date insert_date, String description, int priority, String status, int patientId, int doctorId, Doctor doctor, Patient patient) {
//        this.id = id;
//        this.insert_date = insert_date;
//        this.description = description;
//        this.priority = priority;
//        this.status = status;
//        this.patId = patientId;
//        this.docId = doctorId;
//        this.doctor = doctor;
//        this.patient = patient;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public int getPatientId() {
//        return patId;
//    }
//
//    public void setPatientId(int patientId) {
//        this.patId = patientId;
//    }
//
//    public int getDoctorId() {
//        return docId;
//    }
//
//    public void setDoctorId(int doctorId) {
//        this.docId = doctorId;
//    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }
}
