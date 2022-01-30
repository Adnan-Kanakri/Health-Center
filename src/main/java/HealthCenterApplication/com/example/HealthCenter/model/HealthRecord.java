package HealthCenterApplication.com.example.HealthCenter.model;


import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "record")
@NoArgsConstructor
@ToString
public class HealthRecord {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "record")
    private Patient patient;

    @ManyToOne
    private Appointment appointment;

//    public HealthRecord() {
//    }

    public HealthRecord(int id, Patient patient, Appointment appointment) {
        this.id = id;
        this.patient = patient;
        this.appointment = appointment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
}
