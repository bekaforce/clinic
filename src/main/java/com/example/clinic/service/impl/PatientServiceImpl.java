package com.example.clinic.service.impl;

import com.example.clinic.dto.PatientDto;
import com.example.clinic.model.Patient;
import com.example.clinic.repository.PatientRepo;
import com.example.clinic.service.PatientService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepo patientRepo;
    private final BaseServiceImpl baseService;

    public PatientServiceImpl(PatientRepo patientRepo, BaseServiceImpl baseService) {
        this.patientRepo = patientRepo;
        this.baseService = baseService;
    }


    @Override
    public Patient save(PatientDto patientDto) {
        Patient patient = new Patient();
        patient = setPatient(patient, patientDto);
        return patientRepo.save(patient);
    }

    @Override
    public boolean delete(Long patient_id) {
        Patient patient = patientById(patient_id);
        if (patient != null){
            patientRepo.delete(patient);
            return true;
        }
        return false;
    }

    @Override
    public Patient update(PatientDto patientDto, Long patient_id) {
        Patient patient = patientById(patient_id);
        if (patient != null){
            patient = setPatient(patient, patientDto);
            return patientRepo.save(patient);
        }
        return null;
    }

    @Override
    public List<Patient> all() {
        return patientRepo.findAll();
    }

    @Override
    public Patient patientById(Long patient_id) {
        return patientRepo.findPatientById(patient_id);
    }

    @Override
    public Patient setPatient(Patient patient, PatientDto patientDto) {
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setBirthday(patientDto.getBirthday());
        patient.setRegistrationDate(baseService.now());
        return patient;
    }
}
