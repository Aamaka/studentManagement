package com.semicolon.studentmanagement.controllers;

import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {


    private final StudentService service;

    @PostMapping("/add")
    public AddStudentResponse add(@RequestBody AddStudentRequest student){
       return service.addStudent(student);

    }
    @GetMapping("/getAll")
    public List<Student> getAllStudent(){
        return service.getAllStudent();
    }

    @DeleteMapping(path = "/{studentId}")
    public DeleteStudentResponse deleteStudent(@PathVariable("studentId") String studentId){
        return service.delete(studentId);
    }

    @PutMapping(path = "/{studentId}")
    public UpdateResponse updateStudent(@PathVariable("studentId") String id, @RequestParam(required = false) String name, @RequestParam(required = false) String email){
        return service.updateStudent(id, name, email);

    }

    @GetMapping("/name")
    public Student findStudentByName(@RequestBody String name){
        return service.findStudentByName(name);
    }

}
