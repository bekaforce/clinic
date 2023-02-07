package com.example.clinic.controller;

import com.example.clinic.dto.DoctorDto;
import com.example.clinic.model.Doctor;
import com.example.clinic.service.impl.DoctorServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = Endpoint.DOCTOR)
public class DoctorController {
    private final DoctorServiceImpl doctorService;

    public DoctorController(DoctorServiceImpl doctorService) {
        this.doctorService = doctorService;
    }

    @DeleteMapping(Endpoint.DELETE + "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id") Long id){
        boolean response = doctorService.delete(id);
        return response
                ? new ResponseEntity<>("Doctor was removed by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping(Endpoint.SAVE)
    public ResponseEntity<?> save(@RequestBody DoctorDto doctorDto){
        Doctor response = doctorService.save(doctorDto);
        return response != null
                ? new ResponseEntity<>(response, HttpStatus.OK)
                : new ResponseEntity<>("Try Again", HttpStatus.NOT_FOUND);
    }

    @PutMapping(Endpoint.UPDATE + "/{id}")
    public ResponseEntity<?> update(@RequestBody DoctorDto doctorDto, @PathVariable(value = "id") Long id){
        Doctor response = doctorService.update(doctorDto, id);
        return response != null
                ? new ResponseEntity<>("Doctor was updated by id: " + id, HttpStatus.OK)
                : new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }

    @GetMapping(Endpoint.ALL)
    public ResponseEntity<?> all(){
        List<Doctor> response = doctorService.all();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
