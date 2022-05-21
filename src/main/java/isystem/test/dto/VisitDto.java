package isystem.test.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import isystem.test.model.Doctor;
import isystem.test.model.Patient;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter


@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitDto {
    private Integer id;
    private String diagnosis;
    private Boolean status;
    private LocalDateTime createdAt;
    private Doctor doctor;
    private Integer doctorId;
    private Patient patient;
    private Integer patientId;
}
