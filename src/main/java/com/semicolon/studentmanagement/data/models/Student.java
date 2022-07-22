package com.semicolon.studentmanagement.data.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
    @NonNull
    private String address;
    @NonNull
    private LocalDate dob;
    @Transient
    private int age;

    private String studentId;

    public int getAge(){
        return Period.between(this.dob, LocalDate.now()).getYears();
    }
}
