package isystem.test.service;



import isystem.test.exception.BadRequest;
import isystem.test.repository.VisitRepository;
import isystem.test.model.Visit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class VisitService {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private PatientService patientService;

    public Visit get(Integer id) {
        Optional<Visit> optional = visitRepository.findById(id);
        if (optional.isEmpty()) {
            throw new BadRequest("Visit not found");
        }
        return optional.get();
    }
    public Visit create(Visit visit) {
        //TODO : check doctor
        doctorService.check(visit.getDoctorId());
        //TODO : check patient
        patientService.check(visit.getPatientId());

        visit.setCreatedAt(LocalDateTime.now());
        visit.setStatus(true);
        visitRepository.save(visit);
        return visit;
    }
    public Visit update(Integer id, Visit visit) {
        Visit old = get(id);
        //TODO : check doctor
        doctorService.check(visit.getDoctorId());
        old.setDoctorId(visit.getDoctorId());
        //TODO : check patient
        patientService.check(visit.getPatientId());
        old.setPatientId(visit.getPatientId());

        old.setDiagnosis(visit.getDiagnosis());
        visitRepository.save(old);
        return old;
    }

    public Boolean delete(Integer id) {
        Visit visit = get(id);
        visitRepository.delete(visit);
        return true;
    }
}
