package com.example.clinic.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "patient")
public class Patient extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime registrationDate;
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private List<Record> records;
}
