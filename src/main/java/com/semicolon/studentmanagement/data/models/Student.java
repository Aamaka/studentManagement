package com.semicolon.studentmanagement.data.models;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    private String phoneNumber;

    private String address;

    private LocalDateTime dob;

    private String studentId;

}
