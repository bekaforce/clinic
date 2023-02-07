package com.example.clinic.service.impl;

import com.example.clinic.dto.DoctorDto;
import com.example.clinic.model.Doctor;
import com.example.clinic.repository.DoctorRepo;
import com.example.clinic.service.DoctorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepo doctorRepo;

    public DoctorServiceImpl(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor = setDoctor(doctor, doctorDto);
        return doctorRepo.save(doctor);
    }

    @Override
    public boolean delete(Long doctor_id) {
        Doctor doctor = doctorById(doctor_id);
        if (doctor != null){
            doctorRepo.delete(doctor);
            return true;
        }
        return false;
    }

    @Override
    public Doctor update(DoctorDto doctorDto, Long doctor_id) {
        Doctor doctor = doctorById(doctor_id);
        if (doctor != null){
            doctor = setDoctor(doctor, doctorDto);
            return doctorRepo.save(doctor);
        }
        return null;
    }

    @Override
    public List<Doctor> all() {
        return doctorRepo.findAll();
    }

    @Override
    public Doctor doctorById(Long doctor_id) {
        return doctorRepo.findDoctorById(doctor_id);
    }

    @Override
    public Doctor setDoctor(Doctor doctor, DoctorDto doctorDto) {
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setSpeciality(doctorDto.getSpeciality());
        doctor.setBirthday(doctorDto.getBirthday());
        return doctor;
    }
}
