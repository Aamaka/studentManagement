package com.semicolon.studentmanagement.controllers;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping("/add")
    public AddStudentResponse add(@RequestBody AddStudentRequest student){
       return service.addStudent(student);

    }
    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return service.getAllStudent();
    }

    @DeleteMapping(path = "{studentId")
    public void deleteStudent(@PathVariable("studentId") String studentId){

    }

}
