package com.semicolon.studentmanagement.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddStudentRequest {
    private String name;

    private String email;

    private String address;

//    private LocalDate dob;

}
