package com.example.clinic.controller;

import com.example.clinic.dto.PatientDto;
import com.example.clinic.model.Patient;
import com.example.clinic.service.impl.PatientServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Endpoint.PATIENT)
public class PatientController {
    private final PatientServiceImpl patientService;

    public PatientController(PatientServiceImpl patientService) {
        this.patientService = patientService;
    }

    @DeleteMapping(Endpoint.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = patientService.delete(id);
        return response
                ? new ResponseEntity<>("Patient was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Endpoint.SAVE)
    public ResponseEntity<?> save(@RequestBody PatientDto patientDto){
        Patient response = patientService.save(patientDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Endpoint.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody PatientDto patientDto, @PathVariable(value = "id") Long id){
        Patient response = patientService.update(patientDto, id);
        return response != null
                ? new ResponseEntity<>("Patient was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Endpoint.ALL)
    public ResponseEntity<?> all(){
        List<Patient> response = patientService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
