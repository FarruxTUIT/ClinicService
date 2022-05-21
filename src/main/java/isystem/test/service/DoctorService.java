package isystem.test.service;

import isystem.test.exception.BadRequest;
import isystem.test.repository.DoctorRepository;
import isystem.test.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;


@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor get(Integer id){
        return check(id);
    }
    public Doctor create(Doctor doctor) {
        doctor.setCreatedAt(LocalDateTime.now());
        doctor.setStatus(true);
        doctorRepository.save(doctor);
        return doctor;
    }
    public Doctor update(Doctor doctor, Integer id) {
        Doctor old =get(id);
        old.setContact(doctor.getContact());
        old.setDirection(doctor.getDirection());
        old.setName(doctor.getName());
        old.setSurname(doctor.getSurname());
        old.setExperience(doctor.getExperience());
        doctorRepository.save(old);
        return old;
    }

    public Boolean delete(Integer id) {
        Doctor doctor = get(id);
        doctorRepository.delete(doctor);
        return true;
    }

    public Doctor check(Integer id) {
        Optional<Doctor> optional = doctorRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Doctor not found");
        }
        return optional.get();
    }

}
