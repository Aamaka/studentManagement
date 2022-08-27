package com.semicolon.studentmanagement.controllers;
import com.semicolon.studentmanagement.data.models.Student;
import com.semicolon.studentmanagement.dto.Responses.AddStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.DeleteStudentResponse;
import com.semicolon.studentmanagement.dto.Responses.UpdateResponse;
import com.semicolon.studentmanagement.dto.requests.AddStudentRequest;
import com.semicolon.studentmanagement.dto.requests.UpdateStudentRequest;
import com.semicolon.studentmanagement.exceptions.StudentExistException;
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
    public DeleteStudentResponse deleteStudent(@PathVariable("studentId") long studentId){
        DeleteStudentResponse response = new DeleteStudentResponse();

        try {
            service.delete(studentId);
        }catch (StudentExistException e){
            response.setMessage("student does not exist");
        }
        return response;
    }

    @PutMapping(path = "/{studentId}")
    public UpdateResponse updateStudent(@PathVariable("studentId") long id,
                                        @RequestParam UpdateStudentRequest request){
        return service.updateStudent(id, request);

    }

    @GetMapping("/name")
    public Student findStudentByName(@RequestBody String firstName, String lastName){
        return service.findStudentByName(firstName, lastName);
    }

}
