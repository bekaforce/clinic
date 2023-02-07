package com.example.clinic.dto;

import com.example.clinic.model.BaseEntity;
import lombok.Data;

@Data
public class DoctorDto extends BaseEntity {
    private String speciality;
}
