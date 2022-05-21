package isystem.test.service;


import isystem.test.dto.PatientDto;
import isystem.test.exception.BadRequest;
import isystem.test.repository.PatientRepository;
import isystem.test.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class PatientService {
    @Autowired
    private PatientRepository patientRepository;

    public PatientDto get(Integer id) {
        Patient patient =  check(id);
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setAge(patient.getAge());
        patientDto.setBirthday(patient.getBirthday());
        patientDto.setContact(patient.getContact());
        return patientDto;
    }

    public PatientDto create(PatientDto patientDto) {
        Patient patient = new Patient();
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setBirthday(patientDto.getBirthday());
        patient.setAge(LocalDate.now().getYear() - patientDto.getBirthday().getYear());
        patient.setContact(patientDto.getContact());
        patient.setStatus(true);
        patient.setCreatedAt(LocalDateTime.now());
        patientRepository.save(patient);
        patientDto.setId(patient.getId());
        return patientDto;
    }

    public Patient update(Integer id, Patient patient) {
        Patient old = check(id);
        old.setContact(patient.getContact());
        old.setName(patient.getName());
        old.setSurname(patient.getSurname());
        return old;
    }

    public Boolean delete(Integer id) {
        Patient patient = check(id);
        patientRepository.delete(patient);
        return true;
    }

    public Patient check(Integer id) {
        Optional<Patient> optional = patientRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Patient not found");
        }
        return optional.get();
    }
}
