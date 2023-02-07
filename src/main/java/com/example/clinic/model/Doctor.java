package com.example.clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "doctor")
public class Doctor extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String speciality;
    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private List<Record> records;
}
