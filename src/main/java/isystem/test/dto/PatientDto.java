package isystem.test.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Getter
@Setter
public class PatientDto {

    private Integer id;
    @NotBlank(message = "Ismni to'liq emas")
    @Size(min = 2)
    private String name;
    @NotNull(message = "Familiya to'liq emas")
    @NotEmpty(message = "Familiya bo'sh bolishi mumkin emas")
    @Size(min = 0, max = 255)
    private String surname;
    @NotNull(message = "Invalid birthday")
    private LocalDateTime birthday;
    @NotBlank(message = "Invalid contact")
    @Size(min = 12, max = 13,message = ("Contactni to'gri kiriting *** 12-13 oralig'ida"))
    private Integer contact;
    private Integer age;
    private String status;
    private LocalDateTime createdAt;
}
