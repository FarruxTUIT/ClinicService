package isystem.test.controller;


import isystem.test.dto.PatientDto;
import isystem.test.service.PatientService;
import isystem.test.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/patient")

public class PatientController {

    @Autowired
    private PatientService patientService;


    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid PatientDto patient) {
        PatientDto result = patientService.create(patient);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id) {
        PatientDto  result = patientService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody @Valid Patient patient, @PathVariable("id") Integer id) {
        Patient result = patientService.update(id, patient);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        Boolean result = patientService.delete(id);
        return ResponseEntity.ok(result);
    }
}
