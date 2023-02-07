package com.example.clinic.repository;

import com.example.clinic.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findPatientById(Long id);
}
