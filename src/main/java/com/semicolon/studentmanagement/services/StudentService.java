package com.semicolon.studentmanagement.services;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.dto.requests.UpdateStudentRequest;

import java.util.List;

public interface StudentService {

    AddStudentResponse addStudent(AddStudentRequest request);
     List<Student> getAllStudent();

     DeleteStudentResponse delete(long id);

    UpdateResponse updateStudent(long id, UpdateStudentRequest request);

    Student findStudentByName(String firstName, String lastName);
}

