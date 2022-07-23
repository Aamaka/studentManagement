package com.semicolon.studentmanagement.data.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
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

//    private LocalDate dob;

//    private int age;

    private String studentId;
//
//    public int getAge(){
//        return Period.between(this.dob, LocalDate.now()).getYears();
//    }
}
