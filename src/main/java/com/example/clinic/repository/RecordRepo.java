package com.example.clinic.repository;

import com.example.clinic.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepo extends JpaRepository<Record, Long> {
    Record findRecordById(Long id);
}
