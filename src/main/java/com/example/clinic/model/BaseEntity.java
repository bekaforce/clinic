package com.example.clinic.model;

import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class BaseEntity {
    private String name;
    private String surname;
    private LocalDate birthday;
}
