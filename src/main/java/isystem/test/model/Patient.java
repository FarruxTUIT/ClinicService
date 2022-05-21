package isystem.test.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("patients"))

public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Integer id;

    private String name;

    private String surname;

    private LocalDateTime birthday;

    private Integer contact;

    private Integer age;

    private Boolean status;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;
}
