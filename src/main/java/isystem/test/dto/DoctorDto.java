package isystem.test.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class DoctorDto {
    private Integer id;
    private String name;
    private String surname;
    private String direction;
    private String contact;
    private Integer experience;
    private Boolean status;
    @Column(name = ("created_At"))
    private LocalDateTime createdAt;
}
