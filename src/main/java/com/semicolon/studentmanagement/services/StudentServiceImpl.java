package com.semicolon.studentmanagement.services;

import com.semicolon.studentmanagement.Mapper;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.data.repositories.StudentRepository;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{


    private final StudentRepository studentRepository;

    @Override
    public AddStudentResponse addStudent(AddStudentRequest request) {
        Student student = new Student();
        Mapper.map(request, student);

        String studentId = String.valueOf(UUID.randomUUID().getMostSignificantBits());
        studentId ="ST"+ studentId.substring(1, 4);

        student.setStudentId(studentId);

        Student saveStudent = studentRepository.save(student);
        AddStudentResponse response = new AddStudentResponse();
        Mapper.map(saveStudent, response);
        return response;
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }
}
