package com.example.clinic.service;

import com.example.clinic.dto.DoctorDto;
import com.example.clinic.model.Doctor;

import java.util.List;

public interface DoctorService {
    Doctor save(DoctorDto doctorDto);
    boolean delete(Long doctor_id);
    Doctor update(DoctorDto doctorDto, Long doctor_id);
    List<Doctor> all();
    Doctor doctorById(Long doctor_id);
    Doctor setDoctor(Doctor doctor, DoctorDto doctorDto);
}
