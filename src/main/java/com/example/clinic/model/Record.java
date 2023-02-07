package com.example.clinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "record")
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;
    private LocalDateTime appointmentTime;
    private String description;
    private String conclusion;
    private String status;
}
