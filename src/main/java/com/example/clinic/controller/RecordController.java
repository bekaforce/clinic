package com.example.clinic.controller;

import com.example.clinic.dto.PatientDto;
import com.example.clinic.dto.RecordDto;
import com.example.clinic.model.Patient;
import com.example.clinic.model.Record;
import com.example.clinic.service.impl.RecordServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Endpoint.RECORD)
public class RecordController {
    private final RecordServiceImpl recordService;

    public RecordController(RecordServiceImpl recordService) {
        this.recordService = recordService;
    }

    @DeleteMapping(Endpoint.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = recordService.delete(id);
        return response
                ? new ResponseEntity<>("Record was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Endpoint.SAVE)
    public ResponseEntity<?> save(@RequestBody RecordDto recordDto){
        Record response = recordService.save(recordDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Endpoint.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody RecordDto recordDto, @PathVariable(value = "id") Long id){
        Record response = recordService.update(recordDto, id);
        return response != null
                ? new ResponseEntity<>("Record was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Endpoint.ALL)
    public ResponseEntity<?> all(){
        List<Record> response = recordService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
