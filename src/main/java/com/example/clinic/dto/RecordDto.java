package com.example.clinic.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RecordDto {
    private Long patient_id;
    private Long doctorId;
    private LocalDateTime appointmentTime;
    private String description;
    private String conclusion;
    private String status;
}
