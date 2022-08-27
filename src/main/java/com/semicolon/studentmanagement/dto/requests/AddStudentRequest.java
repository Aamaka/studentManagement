package com.semicolon.studentmanagement.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddStudentRequest {
    private String firstName;

    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    private String address;

    private String phoneNumber;

    private String dob;

}
