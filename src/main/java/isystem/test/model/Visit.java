package isystem.test.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("visits"))

public class Visit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String diagnosis;

    private Boolean status;

    @Column(name = ("created_At"))
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = ("doctor_id"), insertable = false, updatable = false)
    private Doctor doctor;

    @Column(name = ("doctor_id"))
    private Integer doctorId;

    @ManyToOne
    @JoinColumn(name = ("patient_id"), insertable = false, updatable = false)
    private Patient patient;

    @Column(name = ("Patient_id"))
    private Integer patientId;


}
