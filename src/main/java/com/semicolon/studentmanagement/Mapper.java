package com.semicolon.studentmanagement;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;

public class Mapper {

    public static void map(AddStudentRequest request, Student student) {
        student.setName(request.getName());
        student.setAddress(request.getAddress());
        student.setDob(request.getDob());
        student.setEmail(request.getEmail());
    }

    public static void map(Student saveStudent, AddStudentResponse response) {
        response.setMessage("Welcome " + saveStudent.getName() + " to Semicolon");
    }
}
