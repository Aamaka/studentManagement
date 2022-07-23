package com.semicolon.studentmanagement.services;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;

import java.util.List;

public interface StudentService {

    AddStudentResponse addStudent(AddStudentRequest request);
     List<Student> getAllStudent();

     DeleteStudentResponse delete(String request);

    UpdateResponse updateStudent(String id, String name, String email);

    Student findStudentByName(String name);
}

