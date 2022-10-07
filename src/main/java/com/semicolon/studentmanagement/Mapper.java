package com.semicolon.studentmanagement;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Mapper {

    public static void map(AddStudentRequest request, Student student) {
        student.setFirstName(request.getFirstName());
        student.setLastName(request.getLastName());
        student.setAddress(request.getAddress());
        DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        student.setDob(LocalDateTime.parse(request.getDob(), dateTimeFormat));
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
    }
    
    public static void map(Student saveStudent, AddStudentResponse response) {
        response.setMessage(saveStudent.getFirstName()+" ,Welcome to Semicolon.");
        response.setStudentId("STUDENTID: "+saveStudent.getStudentId());
    }
}
