package com.example.clinic.service;

import com.example.clinic.dto.RecordDto;
import com.example.clinic.model.Doctor;
import com.example.clinic.model.Patient;
import com.example.clinic.model.Record;

import java.util.List;

public interface RecordService {
    Record save(RecordDto recordDto);
    boolean delete(Long record_id);
    Record update(RecordDto recordDto, Long record_id);
    List<Record> all();
    Record recordById(Long record_id);
    Record setRecord(Record record, Doctor doctor, Patient patient, RecordDto recordDto);
}
