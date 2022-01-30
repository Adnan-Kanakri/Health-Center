package HealthCenterApplication.com.example.HealthCenter.model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "department")
@NoArgsConstructor
@ToString
public class Department {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "department")
    private Set<DoctorDepartment> doctorDepartment = new HashSet();

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumns({@JoinColumn(name = "doctor_id"),
//            @JoinColumn(name = "department_id")})
//    private DoctorDepartment departmentDoctor;


    public Department(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
