package com.example.clinic.service.impl;

import com.example.clinic.dto.RecordDto;
import com.example.clinic.model.Doctor;
import com.example.clinic.model.Patient;
import com.example.clinic.model.Record;
import com.example.clinic.repository.RecordRepo;
import com.example.clinic.service.RecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {
    private final RecordRepo recordRepo;
    private final DoctorServiceImpl doctorService;
    private final PatientServiceImpl patientService;

    public RecordServiceImpl(RecordRepo recordRepo, DoctorServiceImpl doctorService, PatientServiceImpl patientService) {
        this.recordRepo = recordRepo;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @Override
    public Record save(RecordDto recordDto) {
        Doctor doctor = doctorService.doctorById(recordDto.getDoctorId());
        Patient patient = patientService.patientById(recordDto.getPatient_id());
        if(doctor != null && patient != null){
            Record record = new Record();
            record = setRecord(record, doctor, patient, recordDto);
            return recordRepo.save(record);
        }
        return null;
    }

    @Override
    public boolean delete(Long record_id) {
        Record record = recordById(record_id);
        if (record != null){
            recordRepo.delete(record);
            return true;
        }
        return false;
    }

    @Override
    public Record update(RecordDto recordDto, Long record_id) {
        Record record = recordById(record_id);
        if (record != null){
            Doctor doctor = doctorService.doctorById(recordDto.getDoctorId());
            Patient patient = patientService.patientById(recordDto.getPatient_id());
            record = setRecord(record, doctor, patient, recordDto);
            return recordRepo.save(record);
        }
        return null;
    }

    @Override
    public List<Record> all() {
        return recordRepo.findAll();
    }

    @Override
    public Record recordById(Long record_id) {
        return recordRepo.findRecordById(record_id);
    }

    @Override
    public Record setRecord(Record record, Doctor doctor, Patient patient, RecordDto recordDto) {
        record.setPatient(patient);
        record.setDoctor(doctor);
        record.setAppointmentTime(recordDto.getAppointmentTime());
        record.setConclusion(recordDto.getConclusion());
        record.setDescription(recordDto.getDescription());
        record.setStatus(recordDto.getStatus());
        return record;
    }
}
