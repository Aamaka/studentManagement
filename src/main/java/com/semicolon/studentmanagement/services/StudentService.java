package com.semicolon.studentmanagement.services;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;

import java.util.List;

public interface StudentService {

    AddStudentResponse addStudent(AddStudentRequest request);
     List<Student> getAllStudent();
}
