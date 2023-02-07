package com.example.clinic.service;

import com.example.clinic.dto.PatientDto;
import com.example.clinic.model.Patient;

import java.util.List;

public interface PatientService {
    Patient save(PatientDto patientDto);
    boolean delete(Long patient_id);
    Patient update(PatientDto patientDto, Long patient_id);
    List<Patient> all();
    Patient patientById(Long patient_id);
    Patient setPatient(Patient patient, PatientDto patientDto);
}
